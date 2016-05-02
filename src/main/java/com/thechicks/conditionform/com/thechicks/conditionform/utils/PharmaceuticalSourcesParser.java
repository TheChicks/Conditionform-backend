package com.thechicks.conditionform.com.thechicks.conditionform.utils;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.PillInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 28..
 */
public class PharmaceuticalSourcesParser {



    public PillInfo onParse(WebDriver webDriver, List<WebElement> webElements) {

        PillInfo pillInfo = new PillInfo();


        for(WebElement w : webElements) {
            List<WebElement> trs = w.findElements(By.tagName("tr"));

            for(WebElement tr : trs) {
               List<WebElement> tds =  tr.findElements(By.tagName("td"));
                String title = tds.get(0).getText();
                String[] context;

                // medi_ko_name  한글약이름, medi_en_name 영문약이름, image_url 이미지URL
                if(title.equals("제품명")) {
                    pillInfo.setMedi_ko_name(tds.get(1).findElement(By.tagName("b")).getText());
                    pillInfo.setMedi_en_name(tds.get(1).findElement(By.tagName("span")).getText());
                    pillInfo.setImage_url(tds.get(2).findElement(By.tagName("img")).getAttribute("src"));
                }
                // ingredient 성분명
                else if (title.equals("성분명")) {
                    List<WebElement> spans = tds.get(1).findElements(By.tagName("span"));
                    String con = "";
                    for(WebElement span : spans) {
                        con += span.getText();
                    }

                    System.out.println(con);


                }
                // assortment 전문/일반 (네이버 : 구분), unitariness_or_complexness 단일/복합
                else if (title.equals("전문 / 일반")) {
                    context = getContexts(tds);
                    pillInfo.setAssortment(context[0]);
                    pillInfo.setUnitariness_or_complexness(context[1]);
                }
                // manufacture_assortment 제조/수입사, seller 판매사
                else if (title.equals("제조 / 수입사")) {
                    context = getContexts(tds);
                    pillInfo.setManufacture_assortment(context[0]);
                    pillInfo.setSeller(context[1]);
                }
                // formulation 제형, taking_route 투여경로
                else if (title.equals("제형")) {
                    context = getContexts(tds);
                    pillInfo.setFormulation(context[0]);
                    pillInfo.setTaking_route(context[1]);
                }
                // welfare_category 복지부분류
                else if (title.equals("복지부 분류")) {
                    pillInfo.setWelfare_category(getContext(tds));

                }
                else if (title.equals("급여정보")) {
                    pillInfo.setInsurance_code(tds.get(1).findElement(By.tagName("span")).getText());
                    System.out.println("[" + title + "] : " + tds.get(1).findElement(By.tagName("span")).getText());
                }

                /*  combination_prohibition 병용금지, age_prohibition 연령금지, pregnant_prohibition 임부금지,
                old_man_caution 노인주의, volume_and_treatment_period_caution 용량/투여기간주의,
                division_caution 분할주의, blood_donation_prohibition 헌혈금기 */
                else if (title.contains("의약품안전성")) {
                    pillInfo = getSafeInfo(pillInfo, tds.get(1).findElements(By.tagName("tr")));

                }
                //shape_info 성상, packing_unit 포장단위
                else if (title.equals("성상")) {
                    context = getContexts(tds);
                    pillInfo.setShape_info(context[0]);
                    pillInfo.setPacking_unit(context[1]);

                }

                //storagint_method 저장방법
                else if (title.contains("저장방법")) {
                    pillInfo.setStoragint_method(getContext(tds));
                }
            }
        }

        //efficacy 효능효과
        pillInfo.setEfficacy(getContextById(webDriver,"tabcon_effect"));

        //dosage 용법용량
        pillInfo.setDosage(getContextById(webDriver,"tabcon_dosage"));

        //precaution 사용상주의사항
        pillInfo.setPrecaution(getContextById(webDriver,"tabcon_caution"));


        //medication_guide 복약지도
        pillInfo.setMedication_guide(getContextById(webDriver,"tabcon_guide"));

        return pillInfo;
    }




    private PillInfo getSafeInfo(PillInfo pillInfo, List<WebElement> trsOfTd) {

        for(WebElement trOfTd: trsOfTd) {

            List<WebElement> tdsOfTr = trOfTd.findElements(By.tagName("td"));
            String title = tdsOfTr.get(0).getText();

            if(title.equals("[병용금기]")) {
                pillInfo.setCombination_prohibition(getContext(tdsOfTr));
            }
            else if (title.equals("[연령금기]")){
                if(tdsOfTr.get(1).getText().contains("없음")) {
                    getContext(tdsOfTr);
                }
                else {
                    pillInfo.setAge_prohibition(tdsOfTr.get(1).findElement(By.tagName("a")).getText());
                    System.out.println(title + " : " + tdsOfTr.get(1).findElement(By.tagName("a")).getText());
                }

            }
            else if (title.equals("[임부금기]")){
                pillInfo.setPregnant_prohibition(getContext(tdsOfTr));
            }
            else if (title.equals("[노인주의]")){
                pillInfo.setOld_man_caution(getContext(tdsOfTr));
            }
            else if (title.contains("[용량/투여기간주의]")){

                if(tdsOfTr.size() == 1) {
                    pillInfo.setVolume_and_treatment_period_caution(title.replace("[용량/투여기간주의]", "").replace(" ",""));
                    System.out.println("[용량/투여기간주의]" + " : " + title.replace("[용량/투여기간주의]", "").replace(" ",""));
                }
                else {
                    pillInfo.setVolume_and_treatment_period_caution(trOfTd.findElement(By.tagName("span")).getText());
                    System.out.println(title + " : " + trOfTd.findElement(By.tagName("span")).getText());
                }
            }
            else if (title.equals("[분할주의]")){
                pillInfo.setDivision_caution(getContext(tdsOfTr));
            }
            else if (title.equals("[헌혈금지]")){
                pillInfo.setBlood_donation_prohibition(getContext(tdsOfTr));
            }
        }

        return pillInfo;

    }



    private String[] getContexts (List<WebElement> tds)  {

        String[] contexts = {tds.get(1).getText(), tds.get(3).getText()};

        System.out.println("[" + tds.get(0).getText() + "] : " + contexts[0] + ", " + "[" + tds.get(2).getText()+ "] : " + contexts[1]);
        return contexts;

    }


    private String getContext (List<WebElement> tds)  {

        String context = tds.get(1).getText();

        System.out.println("[" + tds.get(0).getText() + "] : " + context);
        return context;

    }



    private String getContextById (WebDriver webDriver, String id) {

        List<WebElement> trs = webDriver.findElement(By.id(id)).findElements(By.tagName("tr"));
        String context = trs.get(1).findElement(By.tagName("td")).getText();

        System.out.println("[" + trs.get(0).findElement(By.tagName("td")).getText() + "] : " + context);
        return context;

    }



}


/*
    private String medi_ko_name; // 한글약이름
    private String medi_en_name; // 영문약이름
    private String image_url; // 이미지URL
    private String ingredient; // 성분명
    private String assortment; //전문/일반 //구분
    private String unitariness_or_complexness; // 단일/복합
    private String manufacture_assortment; //제조/수입사
    private String seller;//판매사
    private String formulation; //제형
    private String taking_route; // 투여경로
    private String welfare_category; //복지부분류
    private String insurance_code; //보험코드

    private String combination_prohibition; //병용금지
    private String age_prohibition; //연령금지
    private String pregnant_prohibition; //임부금지
    private String old_man_caution; //노인주의
    private String volume_and_treatment_period_caution; //용량/투여기간주의
    private String division_caution; //분할주의
    private String blood_donation_prohibition; //헌혈금기

    private String shape_info; //성상
    private String packing_unit; //포장단위
    private String storagint_method; //저장방법
    private String efficacy; //효능효과
    private String dosage; //용법용량
    private String precaution; //사용상주의사항
    private String medication_guide; //복약지도

*/
