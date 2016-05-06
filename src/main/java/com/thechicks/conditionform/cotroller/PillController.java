package com.thechicks.conditionform.cotroller;

import com.thechicks.conditionform.model.Pill;
import com.thechicks.conditionform.service.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 14..
 */

@RestController
public class PillController {

    @Autowired
    private PillService pillService;

    @RequestMapping("/pillInformations/all")
    public List<Pill> getAllList() {
        List<Pill> pillList = pillService.findAll();
        return pillList;

    }

    @RequestMapping("/pillInformations/search")
    public List<Pill> getPillInfomationsByName(@RequestParam("word") String word)  {
        List<Pill> pills = pillService.getBySerchWord(word); // DB

//        if(pills.size() == 0) {
//            PillDetailInfoHtmlParser pillDetailInfoHtmlParser = new PillDetailInfoHtmlParser();
//            pills = PillSearchXmlParser.getSearchPillSerchInfoaList(mediName);
//
//            for(Pill p : pills) {
//                System.out.println(p);
//                Pill detailInfo = pillDetailInfoHtmlParser.getDetailInfo(p.getLink());
//                detailInfo.setLink(p.getLink());
//                pillDao.insertPill(detailInfo);
//            }
//
//            pills = pillDao.getPillInfomations(word);
//            return pills;
//        }
//        else {
        return pills;
//        }
    }

}
