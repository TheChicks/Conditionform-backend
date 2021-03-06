package com.thechicks.conditionform.util;

import com.thechicks.conditionform.model.Pill;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 28..
 */
public class PharmaceuticalSourcesParser {

    public Pill onParse(WebDriver webDriver, List<WebElement> webElements) {

        Pill pill = new Pill();


        for(WebElement w : webElements) {
            List<WebElement> trs = w.findElements(By.tagName("tr"));

            for(WebElement tr : trs) {
                List<WebElement> tds =  tr.findElements(By.tagName("td"));
                String title = tds.get(0).getText();
                String[] context = new String[3];

                // medi_ko_name  한글약이름, medi_en_name 영문약이름, image_url 이미지URL
                if(title.equals("제품명")) {

                    context[0] = tds.get(1).findElement(By.tagName("b")).getText();
                    context[1] = tds.get(1).findElement(By.tagName("span")).getText();
                    if(!tds.get(2).findElement(By.tagName("img")).getAttribute("title").equals("식별이미지 없음"))
                        context[2] = tds.get(2).findElement(By.tagName("img")).getAttribute("src");
                    else
                        context[2] = "";

                    handleBlank(context);

                    pill.setKo_name(context[0]);
                    pill.setEn_name(context[1]);
                    pill.setImage_url(context[2]);

                }
                // ingredient 성분명
                else if (title.equals("성분명")) {
                    List<WebElement> as = tr.findElements(By.tagName("a"));
                    context[0] = "";
                    int comma = 0;

                    //setter가 for문 밖에 있으면 null값이 들어간다ㅠㅠ 이상해
                    for(WebElement a : as) {
                        context[0] += a.getText();
                        if(comma++ < as.size()-1) {
                            context[0] += ", ";
                        }
                        pill.setIngredient(context[0]);
                    }

                }
                // assortment 전문/일반 (네이버 : 구분), unitariness_or_complexness 단일/복합
                else if (title.equals("전문 / 일반")) {
                    context = getContexts(tds);
                    context = handleBlank(context);
                    pill.setAssortment(context[0]);
                    pill.setUnitariness_or_complexness(context[1]);
                }
                // manufacture_assortment 제조/수입사, seller 판매사
                else if (title.equals("제조 / 수입사")) {
                    context = handleBlank(getContexts(tds));
                    pill.setManufacture_assortment(context[0]);
                    pill.setSeller(context[1]);
                }
                // formulation 제형, taking_route 투여경로
                else if (title.equals("제형")) {
                    context = getContexts(tds);
                    context = handleBlank(context);
                    pill.setFormulation(context[0]);
                    pill.setTaking_route(context[1]);
                }
                // welfare_category 복지부분류
                else if (title.equals("식약처 분류")) {
                    context[0] = handleBlank(getContext(tds));
                    pill.setKorea_food_and_drug_administration_category(context[0]);

                }
                // insurance_code 보험코드
                else if (title.equals("급여정보")) {

                    if(!tds.get(1).getText().equals("")) {
                        if (!tds.get(1).findElement(By.tagName("div")).getText().contains("비급여")) {
                            pill.setInsurance_code(tds.get(1).findElement(By.tagName("span")).getText());
                        }
                    }
                }

                /*  combination_prohibition 병용금지, age_prohibition 연령금지, pregnant_prohibition 임부금지,
                old_man_caution 노인주의, volume_and_treatment_period_caution 용량/투여기간주의,
                division_caution 분할주의, blood_donation_prohibition 헌혈금기 */
                else if (title.contains("의약품안전성")) {
                    pill = getSafeInfo(pill, tds.get(1).findElements(By.tagName("tr")));

                }
                //shape_info 성상, packing_unit 포장단위
                else if (title.equals("성상")) {
                    context = getContexts(tds);
                    pill.setShape_info(context[0]);
                    pill.setPacking_unit(context[1]);

                }

                //storagint_method 저장방법
                else if (title.contains("저장방법")) {
                    pill.setStoragint_method(getContext(tds));
                }
            }
        }

        //efficacy 효능효과
        pill.setEfficacy(getContextById(webDriver,"tabcon_effect"));

        //dosage 용법용량
        pill.setDosage(getContextById(webDriver,"tabcon_dosage"));

        //precaution 사용상주의사항
        pill.setPrecaution(getContextById(webDriver,"tabcon_caution"));


        //medication_guide 복약지도
        pill.setMedication_guide(getContextById(webDriver,"tabcon_guide"));

//        System.out.println(pill);

        return pill;
    }




    private Pill getSafeInfo(Pill pill, List<WebElement> trsOfTd) {

        for(WebElement trOfTd: trsOfTd) {

            List<WebElement> tdsOfTr = trOfTd.findElements(By.tagName("td"));
            String title = tdsOfTr.get(0).getText();

            if(title.equals("[병용금기]")) {
                pill.setCombination_taboo(getContext(tdsOfTr));
            }
            else if (title.equals("[연령금기]")){
                if(!tdsOfTr.get(1).getText().contains("없음")) {
                    pill.setAge_taboo(tdsOfTr.get(1).findElement(By.tagName("a")).getText());
                }

            }
            else if (title.equals("[임부금기]")){
                pill.setPregnant_taboo(getContext(tdsOfTr));
            }
            else if (title.equals("[노인주의]")){
                pill.setOld_man_caution(getContext(tdsOfTr));
            }
            else if (title.contains("[용량/투여기간주의]")){

                if(tdsOfTr.size() == 1) {
                    pill.setVolume_and_treatment_period_caution(handleBlank(title.replace("[용량/투여기간주의]", "").replace(" ","")));
                }
                else {
                    pill.setVolume_and_treatment_period_caution(handleBlank(trOfTd.findElement(By.tagName("span")).getText()));
                }
            }
            else if (title.equals("[분할주의]")){
                pill.setDivision_caution(getContext(tdsOfTr));
            }
            else if (title.equals("[헌혈금지]")){
                pill.setBlood_donation_prohibition(getContext(tdsOfTr));
            }
        }

        return pill;

    }



    private String[] getContexts (List<WebElement> tds)  {

        String[] contexts = {tds.get(1).getText(), tds.get(3).getText()};
        return contexts;

    }


    private String getContext (List<WebElement> tds)  {
        return handleBlank(tds.get(1).getText());
    }



    private String getContextById (WebDriver webDriver, String id) {

        WebElement contextElement = webDriver.findElement(By.id(id)).findElements(By.tagName("tr")).get(1).findElement(By.tagName("td"));
        List<WebElement> rmContext = contextElement.findElements(By.tagName("table"));
        String context = contextElement.getText();

        for(WebElement e : rmContext) {
            context = context.replace(e.getText(),"");
        }

        context = context.replace("\n\n\n", "\n\n");

        return context;

    }


    private String[] handleBlank (String[] contexts) {

        for(int i = 0; i < contexts.length; i++) {
            if (contexts[i].equals("") || contexts[i].equals("없음"))
                contexts[i] = null;
        }

        return contexts;

    }

    private String handleBlank (String context) {

        if (context.equals("") || context.equals("없음"))
            context = null;
        return context;
    }




}