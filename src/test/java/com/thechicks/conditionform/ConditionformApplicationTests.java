package com.thechicks.conditionform;

import com.thechicks.conditionform.com.thechicks.conditionform.utils.PharmaceuticalSourcesCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConditionformApplication.class)
@WebAppConfiguration



public class ConditionformApplicationTests {

    private PharmaceuticalSourcesCrawler pharmaceuticalSourcesCrawler;

    public  ConditionformApplicationTests() {
        pharmaceuticalSourcesCrawler = new PharmaceuticalSourcesCrawler();
    }


	@Test
	public void contextLoads() {
        pharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=23642");
        pharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=8467");
        pharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=17014");
        pharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=13625");
        pharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=136");
        pharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=10591");
	}


}


