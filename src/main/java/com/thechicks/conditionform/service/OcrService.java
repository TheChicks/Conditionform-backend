package com.thechicks.conditionform.service;

import com.thechicks.conditionform.dao.PillDao;
import com.thechicks.conditionform.imageprocessing.ImageProcessing;
import com.thechicks.conditionform.model.Candidate;
import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.model.Pill;
import com.thechicks.conditionform.ocr.OcrUtil;
import com.thechicks.conditionform.ocr.PillNameReplacer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class OcrService {

    @Autowired
    private ImageProcessing imageProcessing;

    @Autowired
    private OcrUtil ocrUtil;

    @Autowired
    private PillDao pillDao;

    public List<OcrResult> getOcrResult(MultipartFile multipartFile){

        if(!multipartFile.isEmpty()){

            File file = outputFile(multipartFile);  //파일 저장
            file = imageProcessing.doImageProcessing(file.getPath(),".jpg");  //전처리

            //ocr 돌리고
            //후처리하고
            //DB의 약이름으로 교체하고
            //리턴
            return doResultFilitering(ocrUtil.getOcrProcessingResult(file));
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
    public List<OcrResult> doResultFilitering(List<OcrResult> beforeResult) {

        for(int i = 0; i < beforeResult.size(); i++) {

            Pill pill;

            if(!beforeResult.get(i).getPill().getInsurance_code().equals("0")) { //보험코드가 있을때 보험코드로 검색한 약 이름을 대체.
                pill = doResultFilteringByInsuranceCode(beforeResult.get(i).getPill());

            } else { //보험코드가 없을때는 이름 비슷한 걸로 대체.
                pill = doResultFilteringByName(beforeResult.get(i).getPill());
            }

            beforeResult.get(i).setPill(pill);
        }

        return beforeResult;
    }



    private Pill doResultFilteringByName(Pill beforeResult) { // 후처리한 결과를 DB에 저장된 약품 이름으로 대체.

        PillNameReplacer pillNameReplacer = new PillNameReplacer();


        String pillName = beforeResult.getKo_name().replaceAll(",", "").replaceAll("`", "").replaceAll("`", "").replaceAll("-", "").replaceAll("'", "").replaceAll("_", "");;

        if (pillName != null) {
            List<String> splitedPillNameList = pillNameReplacer.splitPillName(pillName); //Ocr결과가 보통 앞뒤가 이상하게 읽히므로 자름.
            List<Candidate> candidateList = new ArrayList<>();


            for (String splitedPillName : splitedPillNameList) {

                //자른 약이름으로 DB에 검색한후 중복을 제거한다.
                List<String> searchedPillNameList = new ArrayList<>(new HashSet<>(pillDao.getPillNameByPillNamePart(splitedPillName)));

                for (String searchedPillName : searchedPillNameList) { // 자른 약 이름과 검색한 약 이름의 단어 사이의 거리를 구함.
                    splitedPillName = searchedPillName.replaceAll("[0-9]", "").replaceAll("[a-z]", "").replaceAll("[A-Z]", "");
                    System.out.println(splitedPillName);
                    candidateList.add(new Candidate(searchedPillName, splitedPillName, pillNameReplacer.getDistance(searchedPillName, splitedPillName)));
                }

                //자음모음종성으로 나눈다 -> 나중에..
                //List<Character> s1 = Division();
                //List<Character> s2 = Division();

            }

            //최종 후보를 가져온다.
            if (candidateList.size() != 0) {
                beforeResult.setKo_name(pillNameReplacer.getFliteredPillName(pillName, candidateList));
            }
        }

        return beforeResult;

    }



    private Pill doResultFilteringByInsuranceCode(Pill beforeResult) { // 후처리한 결과를 DB에 저장된 약품 이름으로 대체한다.


        //PillNameReplacer pillNameReplacer = new PillNameReplacer();

        String insuranceCode = beforeResult.getInsurance_code();



        if (!insuranceCode.equals("0")) {
            String firstCharacter = insuranceCode.substring(0);


            if (!firstCharacter.equals("6") && firstCharacter.matches("[-+]?\\d*\\.?\\d+")) { //6이 아니고 숫자일때
                insuranceCode = "6" + insuranceCode.substring(1, insuranceCode.length());
            }


            if(firstCharacter.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) { //츤71802840과 같을 때
                insuranceCode  = "6" + insuranceCode.substring(1, insuranceCode.length());
            }
        }

        // 보험코드로 DB에 저장된 약 이름을 검색한다.
        List<String> pillName = pillDao.getPillNameByInsuranceCodePart(insuranceCode);


        if(pillName != null) {
            beforeResult.setKo_name(pillName.get(0));
            beforeResult.setInsurance_code(insuranceCode);
        }


        return beforeResult;

    }

}
