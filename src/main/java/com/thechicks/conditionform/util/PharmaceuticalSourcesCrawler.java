package com.thechicks.conditionform.util;

import com.thechicks.conditionform.model.Pill;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 28..
 */
public class PharmaceuticalSourcesCrawler {


    public Pill crawlPage(String url) {

        WebDriver driver = new HtmlUnitDriver();
        driver.get(url);

        //alert창은 selenium에서 자동으로 accept
        if(!driver.getTitle().equals("")) {
            PharmaceuticalSourcesParser pharmaceuticalSourcesParser = new PharmaceuticalSourcesParser();
            List<WebElement> elements = driver.findElements(By.className("pd_box"));
            Pill pill = pharmaceuticalSourcesParser.onParse(driver, elements);
            return pill;
        } else {
            return null;
        }


    }

}
