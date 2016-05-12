package com.thechicks.conditionform;

import com.thechicks.conditionform.ocr.OcrUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConditionformApplication.class)
@WebAppConfiguration
public class OcrTests {

    @Test
    public void ocrTest() {

        OcrUtil ocrUtil = OcrUtil.getInstance();

        ocrUtil.getOcrProcessingResult("prescription2.jpg");
    }
}
