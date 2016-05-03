package com.thechicks.conditionform.com.thechicks.conditionform.utils;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.PillInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 28..
 */
public class PharmaceuticalSourcesCrawler {


    public PillInfo crawlPage(String url) {

        WebDriver driver = new HtmlUnitDriver();
        driver.get(url);

        //alert창은 selenium에서 자동으로 accept
        if(!driver.getTitle().equals("")) {
            PharmaceuticalSourcesParser pharmaceuticalSourcesParser = new PharmaceuticalSourcesParser();
            List<WebElement> elements = driver.findElements(By.className("pd_box"));
            PillInfo pillInfo = pharmaceuticalSourcesParser.onParse(driver, elements);
            return pillInfo;
        } else {
            return null;
        }


    }
}
