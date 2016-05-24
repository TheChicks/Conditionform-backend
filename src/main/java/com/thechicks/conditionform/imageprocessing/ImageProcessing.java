package com.thechicks.conditionform.imageprocessing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Leeseolhee on 2016. 5. 24..
 */
public class ImageProcessing {



    Mat mat;
    BufferedImage buf_image;


    void doImageProcessing(String path, String fileExt) {
        // TODO Auto-generated method stub
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        path = "images/17.jpg";
        fileExt = ".jpg";

        try {

            //The input image file is not "right" if it has no columns!
            if(Imgcodecs.imread(path).cols() != 0) {
                this.mat = Imgcodecs.imread(path);
                EditMat em = new EditMat(this.mat, this.buf_image);
                this.mat = em.edit();
                MatToBufImg converter = new MatToBufImg(this.mat, fileExt);
                this.buf_image = converter.getImage();
                this.outputImage(this.buf_image, path);
            } else {
                throw new Exception();
            }



        } catch (Exception e) {
            System.out.println("There is problem with the image file name or its contents");
            e.printStackTrace();
        }

    }


    public void outputImage(BufferedImage buf_image, String filepath) {
        String fileNm = filepath.substring(filepath.lastIndexOf("/") + 1);

        try {
            ImageIO.write(buf_image, "png", new File("output/" + fileNm));
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }


}
