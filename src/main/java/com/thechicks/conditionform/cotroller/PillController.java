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

    @RequestMapping("/")
    public String root() {
        return "conditionForm";
    }

    @RequestMapping("/pills/all")
    public List<Pill> getAllList() {
        List<Pill> pillList = pillService.findAll();
        return pillList;
    }

    @RequestMapping("/pills/search")
    public List<Pill> getPillInfomationsByName(@RequestParam("word") String word)  {
        List<Pill> pills = pillService.getBySerchWord(word); // DB
        return pills;
    }

    @RequestMapping("/pills/last")
    public void getLastPillIndex()  {
        System.out.println(pillService.getByLastId());
    }

}
