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

	@Test
	public void contextLoads() {

		PharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=23642");
		PharmaceuticalSourcesCrawler.crawlPage("http://www.health.kr/drug_info/basedrug/show_detail.asp?idx=8467");

	}


}


