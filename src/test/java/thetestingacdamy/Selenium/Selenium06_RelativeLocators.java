package thetestingacdamy.Selenium;
import io.qameta.allure.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

//Link - https://www.aqi.in/in/real-time-most-polluted-city-ranking

public class Selenium06_RelativeLocators {
    @Test
    public void Map() throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.aqi.in/in/real-time-most-polluted-city-ranking");
        WebElement Searchbox = driver.findElement(By.xpath("//input[@placeholder=\"Search City\"]"));
        Searchbox.sendKeys("India", Keys.ENTER);

        Thread.sleep(3000);

        List<WebElement> table = driver.findElements(By.xpath("//table[@id=\"example\"]/tbody/tr/td[2]"));
        for(WebElement l:table){
            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
            System.out.println(s2+"||"+l.getText()+"||"+s1);


//            System.out.println(l.getText());
        }

    }
}
