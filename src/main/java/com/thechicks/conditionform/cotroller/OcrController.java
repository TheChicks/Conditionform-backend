package com.thechicks.conditionform.cotroller;

import com.thechicks.conditionform.model.OcrResult;
import com.thechicks.conditionform.ocr.OcrUtil;
import com.thechicks.conditionform.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class OcrController {

    @Autowired
    private OcrService ocrService;

    //Todo: api 정의, multipart로 사진 받기
    @RequestMapping(value = "/ocr", method = RequestMethod.POST)
    @ResponseBody
    public List<OcrResult> getCcrResult(@RequestParam("prescription")MultipartFile prescription) {

        OcrUtil ocrUtil = new OcrUtil();
        return ocrUtil.getOcrProcessingResult(prescription);

    }


//    @RequestMapping(value = "/articles", method = RequestMethod.POST)
//    @ResponseBody
//    public Article submit(@ModelAttribute Article article){
//        return article;
//    }

//
//    @RequestMapping(value = "/articles/new", method = RequestMethod.GET)
//    public String newArticle(Model model){
//        Article article = new Article();
//        model.addAttribute("article", article);
//        return "new";
//    }
}

