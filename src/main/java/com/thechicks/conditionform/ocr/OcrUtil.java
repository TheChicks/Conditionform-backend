package com.thechicks.conditionform.ocr;

import com.thechicks.conditionform.model.OcrResult;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.web.multipart.MultipartFile;

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

        File file = new File(".");
        currentDirectory = file.getAbsolutePath() + "/output/";
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

    public List<OcrResult> getOcrProcessingResult(MultipartFile prescription) {


        try {
            if (!prescription.isEmpty()) {
                File file = multipartTofile(prescription);
                prescription.transferTo(file);
                String result = iTesseract.doOCR(file);
                Filter filter = new Filter(result);
                filter.getOcrReultList();
                filter.print();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        //        if(!prescription.isEmpty()) {
//            try {
//                fileName = prescription.getOriginalFilename();
//                byte[] bytes = prescription.getBytes();
//
//                File file = new File("C:/Users/Leeseolhee/" + fileName);
//
//                //exception 발생!!!!
//                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream((file)));
//                buffStream.write(bytes);
//                buffStream.close();
//
//                String result = instance.doOCR(file);
//                Filter filter = new Filter(result);
//                filter.print();
//
//
//            } catch (Exception e) {
//
//            }
//        }



        return null;
    }

    public File multipartTofile(MultipartFile multipartFile){
        File convertFile = new File(multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(convertFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertFile;
    }


}
