package com.thechicks.conditionform.com.thechicks.conditionform.cotrollers;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.Pill;
import com.thechicks.conditionform.com.thechicks.conditionform.utils.PillDetailInfoHtmlParser;
import com.thechicks.conditionform.com.thechicks.conditionform.utils.PillSearchXmlParser;
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

    @RequestMapping("/pillInformations/name/{mediName}")
    public List<Pill> getPillInfomationsByName(@PathVariable("mediName") String mediName ) {
        List<Pill> pills = pillDao.getPillInfomationsByName(mediName); // DB

        if(pills.size() == 0) {
            PillDetailInfoHtmlParser pillDetailInfoHtmlParser = new PillDetailInfoHtmlParser();
            pills = PillSearchXmlParser.getSearchPillSerchInfoList(mediName);

            for(Pill p : pills) {
                System.out.println(p);
                Pill detailInfo = pillDetailInfoHtmlParser.getDetailInfo(p.getLink());
                detailInfo.setLink(p.getLink());
                pillDao.insertPill(detailInfo);
            }

            pills = pillDao.getPillInfomationsByName(mediName);
            return pills;
        } else {
            return pills;
        }


    }

    @RequestMapping("/pillInformations/insuranceCode/{insuranceCode}")
    public List<Pill> getPillInfomationsByInsuranceCode(@PathVariable("insuranceCode") String insuranceCode ) {
        List<Pill> pills = pillDao.getPillInfomationsByInsuranceCode(insuranceCode);

        if(pills.size() == 0) {
            PillDetailInfoHtmlParser pillDetailInfoHtmlParser = new PillDetailInfoHtmlParser();
            pills = PillSearchXmlParser.getSearchPillSerchInfoList(insuranceCode);

            for(Pill p : pills) {
                System.out.println(p);
                Pill detailInfo = pillDetailInfoHtmlParser.getDetailInfo(p.getLink());
                detailInfo.setLink(p.getLink());
                pillDao.insertPill(detailInfo);
            }

            pills = pillDao.getPillInfomationsByInsuranceCode(insuranceCode);
            return pills;
        } else {
            return pills;
        }
    }


}
