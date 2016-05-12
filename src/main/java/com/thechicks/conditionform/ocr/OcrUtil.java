package com.thechicks.conditionform.ocr;

import com.thechicks.conditionform.model.OcrResult;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.List;

//Ocr 기능을 담당
public class OcrUtil {

    private static OcrUtil instance;

    private ITesseract iTesseract;

    private String currentDirectory;

    public static OcrUtil getInstance(){
        if(instance == null){
            synchronized (OcrUtil.class){
                if(instance == null){
                    instance = new OcrUtil();
                }
            }
        }
        return instance;
    }

    public OcrUtil(){
        iTesseract = new Tesseract();
        iTesseract.setLanguage("kor");

        File file = new File(".");
        currentDirectory = file.getAbsolutePath() + "/output/";
    }

    public List<OcrResult> getOcrProcessingResult(String fileName){

        //Todo: 파일 경로 수정
        File imageFile = new File(currentDirectory + fileName);
        Filter filter = null;

        try {
            String result = iTesseract.doOCR(imageFile);
            filter = new Filter(result);

        } catch (TesseractException e) {
            e.printStackTrace();
        }

        filter.print();  //디버깅용

        return filter.getOcrArray();
    }
}
