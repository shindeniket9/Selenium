package thetestingacdamy.Selenium.Practice;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Description;

import java.util.List;


public class IndiaMap_practice2 {

    @Test
    @Description("Select Tripura")
    public void map() throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement AgreeBtn = driver.findElement(By.xpath("//input[@type=\"button\"]"));
        AgreeBtn.click();

        List <WebElement> states= driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"][7]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
        for(WebElement state : states){
            if(state.getAttribute("aria-label").contains("Tripura")){
                state.click();
                break;
            }
        }

    }

}
