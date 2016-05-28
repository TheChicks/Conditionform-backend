package com.thechicks.conditionform.imageprocessing;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;

/**
 * Created by Leeseolhee on 2016. 5. 24..
 */
public class EditMat {
    Mat mat;
    BufferedImage image;
    int count;
    byte blue, green, red;
    byte min;

    public EditMat(Mat mat, BufferedImage image){
        this.mat = mat;
        this.image = image;
        count = 0;
        this.blue = 0;
        this.green = 0;
        this.red = 0;

    }

    public Mat edit(){
        Mat destination = new Mat(mat.rows(), mat.cols(), mat.type());
        destination = mat;
        Imgproc.threshold(mat, destination, 127, 220, Imgproc.THRESH_BINARY);


        //Todo: 전처리코드 추가


        return destination;
    }
}
