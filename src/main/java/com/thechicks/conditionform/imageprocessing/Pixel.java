package com.thechicks.conditionform.imageprocessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Leeseolhee on 2016. 5. 24..
 */
public class Pixel {
    BufferedImage image;
    int width;
    int height;

    public Pixel(String path){
        try {
            File input = new File(path);
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            int count = 0;

            for(int i=0; i<height; i++){

                for(int j=0; j<width; j++){

                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                }
            }

        } catch (Exception e) {}
    }
}
