package com.thechicks.conditionform;

import com.thechicks.conditionform.model.Pill;
import com.thechicks.conditionform.service.PillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Leeseolhee on 2016. 5. 28..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConditionformApplication.class)
@WebAppConfiguration
public class PillTests {

    @Autowired
    PillService pillService;


    @Test
    public void handleNullOfPillTest() {

        Pill pill = new Pill();
        System.out.println(pillService.getBySerchWord(pill.getKo_name()));

    }

    @Test
    public void getLastId() {
        System.out.println(pillService.getByLastId());
    }


    @Test
    public void deleteTest() {

        int startId = 3006;

            Pill pill = pillService.getById(3006);
            pillService.delete(pill.getId());
            System.out.println(startId);

    }



}