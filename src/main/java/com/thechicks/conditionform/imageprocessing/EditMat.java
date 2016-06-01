package com.thechicks.conditionform.imageprocessing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.awt.image.BufferedImage;

/**
 * Created by Leeseolhee on 2016. 5. 24..
 */
public class EditMat {
    Mat mat;
    BufferedImage image;

    public EditMat(Mat mat, BufferedImage image) {
        this.mat = mat;
        this.image = image;
    }


    public Mat edit() {

        removeLetter();
        return mat;
    }



    public void removeLetter() {
        //Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BayerBG2BGR);
        //Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2BGR);

//		Core.inRange(mat, new Scalar(0, 0, 0), new Scalar(127, 127, 127), mat);

        // 이미지 가운데 100X100 크기
        int colsMin = mat.cols()/2-50;
        int rowsMin = mat.rows()/2-50;
        int colsMax = colsMin+100;
        int rowsMax = rowsMin+100;
        int size = 10000;
        int pixels[] = new int[mat.cols()*mat.rows()];
        int sum = 0;
        int average = 0;
        int index = 0;

		/*
		for(int i=rowsMin; i<rowsMax; i++){
			for(int j=colsMin; j<colsMax; j++){
				double [] d = mat.get(i, j);
				pixels[index] = (int)d[0];
//				System.out.println(pixels[index++]);
				sum += pixels[index];
				index++;
			}
		}*/

        for(int i=0; i<mat.rows(); i++){
            for(int j=0; j<mat.cols(); j++){
                double [] d = mat.get(i, j);
                pixels[index] = (int)d[0];
//				System.out.println(pixels[index++]);
                sum += pixels[index];
                index++;
            }
        }
        index -= 1;
        average = sum / index;

        System.out.println(average);
        average -= 60;
        Core.inRange(mat, new Scalar(0, 0, 0), new Scalar(average, average, average), mat);


			/*
		if(average > 200){
			Core.inRange(mat, new Scalar(0, 0, 0), new Scalar(127, 127, 127), mat);
		}
		else if(average > 190){
			Core.inRange(mat, new Scalar(0, 0, 0), new Scalar(110, 110, 110), mat);
		}
		else if(average > 170){
			Core.inRange(mat, new Scalar(0, 0, 0), new Scalar(80, 80, 80), mat);
		}
		else{

			Core.inRange(mat, new Scalar(0, 0, 0), new Scalar(146, 110, 110), mat);
		}


		for(int i=0; i<size; i++){

			System.out.print(pixels[i]+" ");

			if(i%100 == 0){
				System.out.println();
			}
		}
		*/
//		System.out.println(mat.dump());

    }


}
