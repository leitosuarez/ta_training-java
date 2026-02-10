package com.epam.training.leonel_suarez.modules_of_course;

import com.epam.training.leonel_suarez.classes.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebDriverSyncDemo {
    public static void main (String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();


        driver.get("https://seleniumhq.org");
        //los elementos van a tardar en cargar y llegar asi que tengo que gestioanr la asincronia
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //creo el wait (si o si)

        // Esperar a que el link sea clickeable
        WebElement pageDocumentLink = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//a[@href='/documentation']")));
        pageDocumentLink.click();

        // Esperar a que cambie el titulo
        wait.until(CustomConditions.changePage("Documentation"));

        // Esperar a que el h1 sea visible
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        System.out.println(title.getText());


        WebElement searchButton = driver.findElement(By.className("DocSearch-Button"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.id("docsearch-input"));
        searchInput.sendKeys("selenium java");


        List<WebElement> options = wait.until(ExpectedConditions //ahora si creo el webelement gestionado
                .presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@id,docsearch-item-)]")));

        System.out.println("counter of options about the search: "+options.size());


        driver.quit();
    }
}
