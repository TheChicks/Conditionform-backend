package com.thechicks.conditionform;

import com.thechicks.conditionform.com.thechicks.conditionform.utils.PillDetailInfoHtmlParser;
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

		PillDetailInfoHtmlParser p = new PillDetailInfoHtmlParser();
		p.getDetailInfo("http://terms.naver.com/entry.nhn?docId=2155629&cid=51000&categoryId=51000");


	}


}


