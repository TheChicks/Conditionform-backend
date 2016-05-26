package com.thechicks.conditionform.ocr;

import com.thechicks.conditionform.model.OcrResult;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

//Ocr 기능을 담당
public class OcrUtil {

    private static OcrUtil instance;

    private ITesseract iTesseract;

    private String currentDirectory;

    public static OcrUtil getInstance() {
        if (instance == null) {
            synchronized (OcrUtil.class) {
                if (instance == null) {
                    instance = new OcrUtil();
                }
            }
        }
        return instance;
    }

    public OcrUtil() {
        iTesseract = new Tesseract();
        iTesseract.setLanguage("kor");

//        File file = new File(".");
//        currentDirectory = file.getAbsolutePath() + "/output/";
    }

//    public void getOcrProcessingResult(String fileName){
//
//        //File imageFile = new File("C:/pproject/" + fileName);
//
//        try {
//            String result = instance.doOCR(imageFile);
//            Filter filter = new Filter(result);
//            filter.print();
//
//        } catch (TesseractException e) {
//            e.printStackTrace();
//        }
//    }


    public List<OcrResult> getOcrProcessingResult(File file) {

        try {
            String result = iTesseract.doOCR(file);
            System.out.println(result);
            Filter filter = new Filter(result);
            filter.divideTextToLine();
            filter.divideLineToResult();
            filter.print();

            return filter.getOcrResults();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
