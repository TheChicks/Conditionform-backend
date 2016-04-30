package com.thechicks.conditionform.com.thechicks.conditionform.utils;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.PillInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 28..
 */
public class PharmaceuticalSourcesCrawler {


    public static PillInfo crawlPage(String url) {

        WebDriver driver = new HtmlUnitDriver();
        PharmaceuticalSourcesParser pharmaceuticalSourcesParser = new PharmaceuticalSourcesParser();
        driver.get(url);


        List<WebElement> elements = driver.findElements(By.className("pd_box"));
        PillInfo pillInfo = pharmaceuticalSourcesParser.onParse(driver, elements);

        return pillInfo;
    }




}
