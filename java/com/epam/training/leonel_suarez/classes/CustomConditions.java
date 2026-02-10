package com.epam.training.leonel_suarez.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> changePage(String page){

        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return input.getTitle().contains(page);
            }
        };
    }
}

//i could utilize expected conditions interface like that,
// both do the same but implements different, one like a function another like a class creating fields and etc.

//public class CustomConditions implements ExpectedCondition<Boolean> {
//    private String page;

 //   public void setPage(String page) {
  //      this.page = page;
  //  }

   // @Override
  //  public Boolean apply(WebDriver input){return input.getTitle().contains(page);}
//}
