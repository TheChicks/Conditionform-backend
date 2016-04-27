package com.thechicks.conditionform.com.thechicks.conditionform.cotrollers;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.Pill;
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
        List<Pill> pillList = pillDao.getPillInfomationsByName(mediName);
        return pillList;
    }

    @RequestMapping("/pillInformations/insuranceCode/{insuranceCode}")
    public List<Pill> getPillInfomationsByInsuranceCode(@PathVariable("insuranceCode") String insuranceCode ) {
        List<Pill> pillList = pillDao.getPillInfomationsByInsuranceCode(insuranceCode);
        return pillList;
    }


}
