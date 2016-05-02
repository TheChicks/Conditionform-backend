package com.thechicks.conditionform.com.thechicks.conditionform.cotrollers;

import com.thechicks.conditionform.com.thechicks.conditionform.models.Pill;
import com.thechicks.conditionform.dao.PillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 14..
 */

@RestController
public class PillController {

    @Autowired
    private PillDao pillDao;

    @RequestMapping("/pillInformations/all")
    public List<Pill> getAllList() {
        List<Pill> pillList = pillDao.findAll();
        return pillList;



    }

    @RequestMapping("/pillInformations/searchWord/{searchWord}")
    public List<Pill> getPillInfomationsByName(@PathVariable("searchWord") String searchWord ) {
        List<Pill> pills = pillDao.getPillInfomations(searchWord); // DB

        if(pills.size() == 0) {
//            PillDetailInfoHtmlParser pillDetailInfoHtmlParser = new PillDetailInfoHtmlParser();
//            pills = PillSearchXmlParser.getSearchPillSerchInfoList(mediName);
//
//            for(Pill p : pills) {
//                System.out.println(p);
//                Pill detailInfo = pillDetailInfoHtmlParser.getDetailInfo(p.getLink());
//                detailInfo.setLink(p.getLink());
//                pillDao.insertPill(detailInfo);
//            }

            pills = pillDao.getPillInfomations(searchWord);
            return pills;
        }
        else {
            return pills;
        }
    }

}
