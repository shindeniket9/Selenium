package thetestingacdamy.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import javax.swing.*;

//1) Drag and drop - practice link "https://the-internet.herokuapp.com/drag_and_drop"

public class Selenium04_Actions {

    @Test
    public void Actions(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);

        // drag and drop method
        actions.dragAndDrop(from,to).build().perform();

        // If drag and drop is not there

        actions.clickAndHold(from).moveToElement(to).release().build().perform();

//        driver.close();
    }
}
