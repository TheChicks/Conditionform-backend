package com.thechicks.conditionform.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OcrUtil {

    private ITesseract instance;

    public OcrUtil(){
        instance = new Tesseract();
        instance.setLanguage("kor");
    }

    public void getOcrProcessingResult(String fileName){

        File imageFile = new File("C:/pproject/" + fileName);

        try {
            String result = instance.doOCR(imageFile);
            Filter filter = new Filter(result);
            filter.print();

        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
