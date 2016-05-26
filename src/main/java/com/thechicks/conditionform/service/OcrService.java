package com.thechicks.conditionform.service;

import com.thechicks.conditionform.imageprocessing.ImageProcessing;
import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.ocr.OcrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Service
public class OcrService {

    @Autowired
    private ImageProcessing imageProcessing;

    @Autowired
    private OcrUtil ocrUtil;

//    public OcrService() {
//        imageProcessing = new ImageProcessing();
//        ocrUtil = new OcrUtil();
//    }

    public List<OcrResult> getOcrResult(MultipartFile multipartFile){

        if(!multipartFile.isEmpty()){
//            File convertFile = multipartTofile(multipartFile);  //multipartFile을 file로 변환

            File file = outputFile(multipartFile);  //파일 저장

            file = imageProcessing.doImageProcessing(file.getPath(),".jpg");  //전처리

            //ocr 돌리고
            //후처리하고
            //리턴하면
            return ocrUtil.getOcrProcessingResult(file);
        }else {
            //뭔가 리턴
           return null;
        }
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
        return ocrUtil.getOcrProcessingResult(file);
        //return null;
    }

    //파일 저장
    private File outputFile(MultipartFile multipartFile)  {

        File outputFile = new File("images/" + multipartFile.getOriginalFilename());
        //System.out.println(" 3 " + outputFile.getAbsoluteFile());

        try {
            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(outputFile));

            bos.write(bytes);
            bos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }
}
