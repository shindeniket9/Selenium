package thetestingacdamy.Selenium;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium01 {

    @Description("Provide Invalid login and password check")
    @Test
    public void Selenium1(){

        EdgeOptions edgejOption = new EdgeOptions();
        edgejOption.setPageLoadStrategy(PageLoadStrategy.EAGER);
        // normal - wait till every resource get download
        // eager  - dom is ready but images are still loading
        // none   - Does not block WebDriver at all

        // if we use eager and none we may miss the bug

        WebDriver driver = new EdgeDriver(edgejOption);
        driver.get("https://app.vwo.com/#/login");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        driver.findElement(By.id("js-login-btn")).click();

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e);
        }

        WebElement errorMsg = driver.findElement(By.id("js-notification-box-msg"));
        String errorMsg_text = errorMsg.getText();
        String errorMsg_Attribute = errorMsg.getAttribute("data-qa");//by providing key we get value

        //linkText - used for hyperlink - and for full exact word
        //partialLinkText - used for partial text /  used for dynamic content

        WebElement HyperLink = driver.findElement(By.linkText("Start a free trial"));
        String HypertLink_text = HyperLink.getAttribute("href");

        System.out.println(errorMsg_text);
        System.out.println(errorMsg_Attribute);
        System.out.println(HypertLink_text);



        Assert.assertEquals(errorMsg_text,"Your email, password, IP address or location did not match");

        HyperLink.click();

        driver.close();
    }
}
