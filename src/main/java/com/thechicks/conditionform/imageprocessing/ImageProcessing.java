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
    BufferedImage bufImage;

    public File doImageProcessing(String path, String fileExt) {
        // TODO Auto-generated method stub

        //System.out.println(Core.NATIVE_LIBRARY_NAME);
        //-Djava.library.path=./opencv_3.1.0
        //System.load("/Users/Leeseolhee/Conditionform-backend/opencv_3.1.0/libopencv_java310.dylib");

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //NativeLibrary.addSearchPath("libopencv_java310","./opencv_3.1.0");
        //Runtime.getRuntime().loadLibrary(Core.NATIVE_LIBRARY_NAME);

        File file = null;

        try {
            //The input image file is not "right" if it has no columns!
            if(Imgcodecs.imread(path).cols() != 0) {
                this.mat = Imgcodecs.imread(path);
                EditMat em = new EditMat(this.mat, this.bufImage);
                this.mat = em.edit();
                MatToBufImg converter = new MatToBufImg(this.mat, fileExt);
                this.bufImage = converter.getImage();

                file = outputImage(this.bufImage, path);  //파일 저장
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("There is problem with the image file name or its contents");
            e.printStackTrace();
        }
       return file;
    }


    private File outputImage(BufferedImage buf_image, String filepath) {
        String fileNm = filepath.substring(filepath.lastIndexOf("/") + 1);

        File file = new File("output/" + fileNm);

        try {
            ImageIO.write(buf_image, "jpeg", file);
            return file;
        } catch (IOException var5) {
            var5.printStackTrace();
            return null;
        }
    }


}
