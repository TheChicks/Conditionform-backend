package com.thechicks.conditionform.cotroller;

import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OcrController {

    @Autowired
    private OcrService ocrService;

    //Todo: api 정의, multipart로 사진 받기
    @RequestMapping(value = "/ocr", method = RequestMethod.POST)
    public List<OcrResult> getCcrResult(){

        List<OcrResult> ocrResults = ocrService.getOcrResult();

        return ocrResults;
    }
}
