package com.thechicks.conditionform.ocr;

import com.thechicks.conditionform.model.OcrResult;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public class OcrUtil {

    private ITesseract instance;

    public OcrUtil(){
        instance = new Tesseract();
        instance.setLanguage("kor");
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
            if(!prescription.isEmpty()) {
              File file = (File)prescription;
              String result = instance.doOCR(file);
              Filter filter = new Filter(result);
                filter.divideTextToLine();
              filter.print();
            }
        } catch (Exception e) {

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


}
