package com.thechicks.conditionform;

import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.model.Pill;
import com.thechicks.conditionform.service.OcrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leeseolhee on 2016. 5. 31..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConditionformApplication.class)
@WebAppConfiguration
public class PillNameReplacerTests {

    @Autowired
    OcrService ocrService;


    @Test
    public void pillNameReplacerTest() {

        String []code = {"671805280", "츤71802840", "642901280", "0"};
        String []name = {"오티텐정", "이토드징", "임포젤정", "비오티스"};

        /*
        671805280, 오티텐정, 1, 3, 3
        츤71802840, 이토드징, 1, 3, 0
        642901280, 임포젤정, 3, 3, 0
        0, 비오티스, 1, 3, 3
         */


        List<OcrResult> ocrResultList = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            OcrResult ocrResult = new OcrResult();
            Pill pill = new Pill();
            pill.setInsurance_code(code[i]);
            pill.setKo_name(name[i]);
            ocrResult.setPill(pill);
            ocrResultList.add(ocrResult);
        }

        ocrResultList = ocrService.doResultFilitering(ocrResultList);


        for(int i = 0; i < 4; i++)
            System.out.println( (i+1) + " : " + ocrResultList.get(i).getPill().getInsurance_code() + ", "+ocrResultList.get(i).getPill().getKo_name());


    }

    /*
        640000920, 솔레톤정, 3, 3, 0
        648200800, 키_、、_, 0, 0, 0
        542902490, 하, 1, 3, 3
    */

    @Test
    public void pillNameReplacerTest2() {

        String []code = {"640000920", "648200800", "542902490"};
        String []name = {"솔레톤정", "키", "하"};
        List<OcrResult> ocrResultList = new ArrayList<>();

        for(int i = 0; i < code.length; i++) {
            OcrResult ocrResult = new OcrResult();
            Pill pill = new Pill();
            pill.setInsurance_code(code[i]);
            pill.setKo_name(name[i]);
            ocrResult.setPill(pill);
            ocrResultList.add(ocrResult);
        }

        ocrResultList = ocrService.doResultFilitering(ocrResultList);


        for(int i = 0; i < code.length; i++)
            System.out.println( (i+1) + " : " + ocrResultList.get(i).getPill().getInsurance_code() + ", "+ocrResultList.get(i).getPill().getKo_name());


    }


    @Test
    public void pillNameReplacerTest3() {

        String []code = {"640000920", "648200800", "542902490"};
        String []name = {"솔레톤정", "키", "하"};
        List<OcrResult> ocrResultList = new ArrayList<>();

        for(int i = 0; i < code.length; i++) {
            OcrResult ocrResult = new OcrResult();
            Pill pill = new Pill();
            pill.setInsurance_code(code[i]);
            pill.setKo_name(name[i]);
            ocrResult.setPill(pill);
            ocrResultList.add(ocrResult);
        }

        ocrResultList = ocrService.doResultFilitering(ocrResultList);


        for(int i = 0; i < code.length; i++)
            System.out.println( (i+1) + " : " + ocrResultList.get(i).getPill().getInsurance_code() + ", "+ocrResultList.get(i).getPill().getKo_name());


    }


    @Test
    public void pillNameReplacerTest4() {

        String []code = {"0", "0", "542902490"};
        String []name = {"솔레톤정", "키", "하"};
        List<OcrResult> ocrResultList = new ArrayList<>();

        for(int i = 0; i < code.length; i++) {
            OcrResult ocrResult = new OcrResult();
            Pill pill = new Pill();
            pill.setInsurance_code(code[i]);
            pill.setKo_name(name[i]);
            ocrResult.setPill(pill);
            ocrResultList.add(ocrResult);
        }

        ocrResultList = ocrService.doResultFilitering(ocrResultList);


        for(int i = 0; i < code.length; i++)
            System.out.println( (i+1) + " : " + ocrResultList.get(i).getPill().getInsurance_code() + ", "+ocrResultList.get(i).getPill().getKo_name());


    }

}
