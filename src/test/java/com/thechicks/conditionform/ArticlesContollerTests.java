package com.thechicks.conditionform;

import com.thechicks.conditionform.cotroller.OcrController;
import com.thechicks.conditionform.service.OcrService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Leeseolhee on 2016. 5. 19..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConditionformApplication.class)
@WebAppConfiguration

public class ArticlesContollerTests {

    Logger logger = Logger.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private OcrController ocrController;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    private OcrService ocrService;

    @Before
    public  void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = webAppContextSetup(wac).build();
    }

//    @Test
//    public void testNewArticle() throws Exception {
//
//        MvcResult result = mockMvc.perform(get("new"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
//                .andExpect(xpath("//input[@name='title']").exists())
//                .andReturn();
//
//    }

//    @Test
//    public void testSubmit() throws Exception {
//
//        MockMultipartFile file = new MockMultipartFile("file", "filename.txt", "text/plain", "some xml".getBytes());
//
//        MvcResult result = mockMvc.perform(
//                fileUpload("/articles").file(file)
//                        .param("title", "unittest title")
//                        .param("content", "unittest content"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        logger.info(result.getResponse().getContentAsString());
//    }


    @Test
    public void testOcr() throws Exception {

        MockMultipartFile image = new MockMultipartFile("prescription", "pre.png", "image/png", "{\"image\": \"C:\\Users\\Leeseolhee\\Conditionform-backend\"}".getBytes());
        MvcResult result = mockMvc.perform(
                fileUpload("/ocr").file(image))
                .andExpect(status().isOk())
                .andReturn();

        logger.info(result.getResponse().getContentAsString());
    }






}