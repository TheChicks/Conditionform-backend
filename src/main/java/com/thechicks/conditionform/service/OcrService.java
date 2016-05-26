package com.thechicks.conditionform.service;

import com.thechicks.conditionform.imageprocessing.ImageProcessing;
import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.ocr.OcrUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class OcrService {


    private ImageProcessing imageProcessing;

    public OcrService() {
        imageProcessing = new ImageProcessing();
    }

    public List<OcrResult> getOcrResult(MultipartFile prescription){

        File file = multipartTofile(prescription);
        file = imageProcessing.doImageProcessing(file.getPath(),".jpg");

        OcrUtil ocrUtil = OcrUtil.getInstance();
        return ocrUtil.getOcrProcessingResult(file);
    }


    public List<OcrResult> getOcrResult(){


        File file = new File("output/20.jpeg");

        try {
            //test용
            //InputStream inputStream = new FileInputStream("images/17.jpg");
            InputStream inputStream = new FileInputStream("output/19.jpeg");
            OutputStream outStream = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len = 0;

            while ((len = inputStream.read(buf)) > 0){
                outStream.write(buf, 0, len);
            }

            outStream.close();
            inputStream.close();

            //file = imageProcessing.doImageProcessing(file.getPath(),".jpg");
        }catch (Exception e) {
            e.printStackTrace();
        }


        OcrUtil ocrUtil = OcrUtil.getInstance();
        return ocrUtil.getOcrProcessingResult(file);
        //return null;

    }





    public File multipartTofile(MultipartFile multipartFile){
        File convertFile = new File("./images/",multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(convertFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertFile;
    }

}
