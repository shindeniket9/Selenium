package thetestingacdamy.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.List;

public class Selenium02 {

    @Test(groups = "QA")
    @Description("Verify the login")
    public void Selenium02(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        List<WebElement> all_tags = driver.findElements(By.tagName("a"));
        for(WebElement element:all_tags){
         System.out.println(element.getText());
        }
    }

}
