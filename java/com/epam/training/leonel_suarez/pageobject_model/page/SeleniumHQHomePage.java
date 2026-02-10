package com.epam.training.leonel_suarez.pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHQHomePage {
    private static final String PAGE_URL = "https://www.selenium.dev/";
    // Driver se recibe, NO se crea aquí
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators como constantes (solo el By, no el WebElement)
    private By searchButton = By.cssSelector("button.DocSearch-Button");
    private By searchInput = By.id("docsearch-input");
    private By searchResults = By.xpath("//li[contains(@id,'docsearch-item-')]");

    public SeleniumHQHomePage(WebDriver driver){
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SeleniumHQHomePage openPage(){
        driver.get(PAGE_URL);
        return this;  // Permite encadenar métodos
    }

    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void enterSearchTerm(String term){
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.sendKeys(term);
    }


    public List<WebElement> searchForTerms(String value){
        clickSearchButton();
        enterSearchTerm(value);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResults));

    }

}
