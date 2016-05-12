package com.thechicks.conditionform.service;

import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.ocr.OcrUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcrService {

    //OcrUtil에서 결과를 받아온다.
    public List<OcrResult> getOcrResult(){
       OcrUtil ocrUtil = OcrUtil.getInstance();

        List<OcrResult> ocrResults = ocrUtil.getOcrProcessingResult("");

        return ocrResults;
    }
}
