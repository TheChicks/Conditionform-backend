package com.thechicks.conditionform.service;

import com.thechicks.conditionform.dao.PillDao;
import com.thechicks.conditionform.imageprocessing.ImageProcessing;
import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.ocr.OcrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class OcrService {

    @Autowired
    private ImageProcessing imageProcessing;

    @Autowired
    private OcrUtil ocrUtil;

    @Autowired
    private PillDao pillDao;

//    public OcrService() {
//        imageProcessing = new ImageProcessing();
//        ocrUtil = new OcrUtil();
//    }

    public List<OcrResult> getOcrResult(MultipartFile multipartFile){

        if(!multipartFile.isEmpty()){

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

    //MultipartFile을 File로 변환하고 저장
    private File outputFile(MultipartFile multipartFile)  {

        File outputFile = new File("images/" + multipartFile.getOriginalFilename());

        try {
            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile));
            bos.write(bytes);
            bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }


    // 후처리한 결과를 DB에 저장된 약품 이름으로 대체한다.
    private List<OcrResult> doResultFiltering(List<OcrResult> beforeResult) {

        for(int i = 0; i < beforeResult.size(); i++) {
            if(beforeResult.get(i).getPillInsuranceCode() != null) {
                String pillName = pillDao.getPillNameByInsuranceCode(beforeResult.get(i).getPillInsuranceCode());

            } else {
                if(beforeResult.get(i).getPillName() != null) {

                }
            }
        }

        return null;
    }

}
