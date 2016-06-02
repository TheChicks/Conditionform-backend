package com.thechicks.conditionform;

import com.thechicks.conditionform.model.Pill;
import com.thechicks.conditionform.service.PillService;
import com.thechicks.conditionform.util.PharmaceuticalSourcesCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 6. 2..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConditionformApplication.class)
@WebAppConfiguration
public class CrawlingTests {

    @Autowired
    PillService pillService;


    @Test
    public void crawlingTest1() {
        PharmaceuticalSourcesCrawler pharmaceuticalSourcesCrawler = new PharmaceuticalSourcesCrawler();
        int []startInx = {76699, 75479, 49323, 46096, 25516, 31967, 64843, 23281, 20369, 25895, 20384, 55908, 25020, 24900};


        for(int i = 0; i < startInx.length; i++) {
            Pill pill = pharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=" + startInx[i]);

            String pillName = pill.getKo_name();
            List<Pill> currnet =  pillService.getBySerchWord(pillName); //DB에 있는지 확인

            if (pill != null && currnet.size() == 0) {
                pillService.insert(pill);
                System.out.println(startInx[i]);
            }
            else
                System.out.println("pill is null");
        }
    }



}
