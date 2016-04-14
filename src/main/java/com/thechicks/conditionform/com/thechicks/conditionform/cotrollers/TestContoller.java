package com.thechicks.conditionform.com.thechicks.conditionform.cotrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leeseolhee on 2016. 4. 14..
 */

@RestController
public class TestContoller {

//    @Autowired
//    private TestDao testDao;

//    @RequestMapping("/test/all")
//    public List<Test> getAllList() {
//        List<Test> testList = testDao.findAll();
//        return testList;
//    }

    @RequestMapping("/test")
    public String getHello() {
        return "Hello";
    }



}
