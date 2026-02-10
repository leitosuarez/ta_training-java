package com.epam.training.leonel_suarez.pageobject_model.test;

import com.epam.training.leonel_suarez.pageobject_model.page.SeleniumHQHomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSeleniumHQTest {
    private WebDriver driver;

    public void setBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void commonSearchResultsAreNotEmpty(){

        int expectedSearchResultsNumber = new SeleniumHQHomePage(driver)
                .openPage()
                .searchForTerms("Selenium Java")
                .size();

        Assertions.assertTrue(expectedSearchResultsNumber > 0,"Search results:"+expectedSearchResultsNumber);

    }


}
