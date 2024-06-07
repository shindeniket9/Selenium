package thetestingacdamy.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;

public class ebay_practice1 {

    EdgeDriver driver;
    @BeforeTest
    public void StartTheBrowser(){
        driver = new EdgeDriver();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver.manage().window().maximize();
    }


    @Test
    public void ebay() throws InterruptedException {
        driver.get("https://www.ebay.com/b/16-GB-RAM-PC-Laptops-Netbooks/177/bn_7114664539");
        WebElement searchbox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchbox.sendKeys("samsung");
        WebElement searchboxbtn = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchboxbtn.click();

        Thread.sleep(3000);

        List<WebElement> titles = driver.findElements(By.className("s-item__title"));
        for(WebElement title:titles ){
            System.out.println(title.getText());
        }
    }


    @AfterTest
    public void CloseBrowser(){
        driver.quit();
    }
}
