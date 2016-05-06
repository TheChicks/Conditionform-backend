package com.thechicks.conditionform.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by Leeseolhee on 2016. 4. 23..
 */

public class PillDetailInfoHtmlParser {

//    public Pill getDetailInfo(String url) {
//
//        Pill pill = new Pill();
//
//        try {
//            Document doc = Jsoup.connect(url).get();
//
//            //pill_kr_name
//            Elements elements = doc.select(".h_group h2");
//            pill.setMedi_ko_name(elements.text());
//            String text = elements.text();
//            System.out.println(text);
//
//
//            //pill_en_name
//            String MediEnName = doc.select(".h_group em").text();
//            MediEnName = MediEnName.replace("[ ","").replace(". ]","");
//            pill.setMedi_en_name(MediEnName);
//            System.out.println(MediEnName);
//
//            //image_url
//            elements = doc.select("#innerImage0");
//            String imageUrl = elements.attr("origin_src");
//            pill.setImage_url(imageUrl);
//            System.out.println(imageUrl);
//
//
//
//            //category_welfare, assortment, manufacture_assort, manufacture_assort_manufacturer, insurance_code, pregnant_rating, age_prohibit
//            elements = doc.select(".tmp_profile_tb tbody tr");
//            for (Element e : elements) {
//                if(e.child(0).text().equals("복지부 분류")) {
//                    System.out.println(e.child(1).text());
//                    pill.setCategory_welfare(e.child(1).text());
//                }else if(e.child(0).text().equals("구분")) {
//                    System.out.println(e.child(1).text());
//                    pill.setAssortment(e.child(1).text());
//                } else if(e.child(0).text().equals("제조·수입 구분")) {
//                    System.out.println(e.child(1).text());
//                    pill.setManufacture_assort(e.child(1).text());
//                } else if(e.child(0).text().equals("제조(수입) 업체명")) {
//                    System.out.println(e.child(1).text());
//                    pill.setManufacture_assort_manufacturer(e.child(1).text());
//                } else if(e.child(0).text().equals("보험코드")) {
//                    System.out.println(e.child(1).text());
//                    pill.setInsurance_code(e.child(1).text());
//                } else if(e.child(0).text().equals("임산부 금기 등급")) {
//                    System.out.println(e.child(1).text());
//                    pill.setPregnant_rating(e.child(1).text());
//                }else if(e.child(0).text().equals("연령 금기")) {
//                    System.out.println(e.child(1).text());
//                    pill.setAge_prohibit(e.child(1).text());
//                }
//            }
//
//            //shape_info_appearance, shape_info_formulation, shape_info_shape, shape_info_color, shape_info_idmark
//            Element element = doc.getElementById("TABLE_OF_CONTENT1");
//            String str[] = element.nextElementSibling().text().split("· ");
//            String str2[];
//            for(int i = 0; i < str.length; i++) {
//                if(str[i].contains("성상")) {
//                    str2 = str[i].split(": ");
//                    pill.setShape_info_appearance(str2[1]);
//                    System.out.println(str2[1]);
//                }else if(str[i].contains("제형")) {
//                    str2 = str[i].split(": ");
//                    pill.setShape_info_formulation(str2[1]);
//                    System.out.println(str2[1]);
//                }else if(str[i].contains("모양")) {
//                    str2 = str[i].split(": ");
//                    pill.setShape_info_shape(str2[1]);
//                    System.out.println(str2[1]);
//                }else if(str[i].contains("색상")) {
//                    str2 = str[i].split(": ");
//                    pill.setShape_info_color(str2[1]);
//                    System.out.println(str2[1]);
//                }else if(str[i].contains("식별표기")) {
//                    str2 = str[i].split(": ");
//                    pill.setShape_info_idmark(str2[1]);
//                    System.out.println(str2[1]);
//                }
//            }
////
//            String context;
//
//            //ingredient_info
//            context = getContext(doc, "TABLE_OF_CONTENT2", "stress");
//            pill.setIngredient_info(context);
//            System.out.println(context);
//
//
//            //storagint_method
//            context = getContext(doc, "TABLE_OF_CONTENT3", "stress");
//            pill.setStoragint_method(context);
//            System.out.println(context);
//
//
//            //efficacy
//            context = getContext(doc, "TABLE_OF_CONTENT4", "stress");
//            pill.setEfficacy(context);
//            System.out.println(context);
//
//
//            //dosage
//            context = getContext(doc, "TABLE_OF_CONTENT5", "stress");
//            pill.setDosage(context);
//            System.out.println(context);
//
//            //precaution
//            context = getContext(doc, "TABLE_OF_CONTENT6", "tmp_source");
//            pill.setPrecaution(context);
//            System.out.println(context);
//
//
//
//        }catch(Exception e) {}
//
//        return pill;
//
//    }


    public String getContext(Document doc, String startElementId, String breakElementClass) {

        String context = "";
        Element element = doc.getElementById(startElementId);
        for(Element e = element.nextElementSibling(); !e.className().equals(breakElementClass); e = e.nextElementSibling()) {

            if(!e.className().equals("box_tbl"))
                context += removeTag(e.html());

        }

        return spaceLine(context);
    }


    public String spaceLine(String context) {

        return context.replace("<br>", "\n").replace("<br />", "\n");
    }

    public String removeTag(String context) {
        return  context.replace("</a>", "").replaceAll("<a[^>]*>", "").replace("&middot", "·");
    }



//    public String spaceLine(String str) {
//
//        String splaceCharacter[] = {" 가. ", " 나. ", " 다. ", " 라. ", " 마. ",  " 바. ", " 사. ", " 아. ", " 자. ", " 차. ", " 카. ", " 타. ", " 파. ", " 하. ",
//        "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩", "⑪", "⑫", "⑬", "⑭", "⑮", "⑯", "⑰", "⑱", "⑲", "⑳", "●", "○"};
//
//        for(int num = 1; num <=20; num++) {
//            str = str.replace(" " + num + ". ", "\n\n" + num + ". ");
//            str = str.replace("(" + num + ") ", "\n" +"(" + num + ") ");
//            str = str.replace(" " +num + ") ", " "+"\n" + num + ") ");
//            str = str.replace("표 "+ num + ".", "\n" + "표 "+ num + ".");
//        }
//
//        for(String s : splaceCharacter)
//            str = str.replace(s, "\n" + s);
//
//        str = str.replace(". - ", "."+ "\n" + "- ");
//
//        return str;
//    }


}
