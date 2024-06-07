package thetestingacdamy.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Iterator;
import java.util.Set;

//link - "https://the-internet.herokuapp.com/windows"

public class Selenium05_windowHandleing {

    @Test
    public void Window(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before"+mainWindowHandle);

        WebElement Link = driver.findElement(By.linkText("Click Here"));
        Link.click();

        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles){
            driver.switchTo().window(handle);
            System.out.println(handle);
        }

        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            String c1 =iterator.next();
        }
    }
}
