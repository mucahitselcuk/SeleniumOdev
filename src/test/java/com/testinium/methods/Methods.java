package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
        logger.info("SendKeys İşlemi Çalıştı");
    }


    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        } catch (Exception e) {
            logger.info("False " + e.getMessage());
            return false;
        }
    }

    public void scrollWithActions(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public void scrollWithJavaScript(By by) {
        jsdriver.executeScript("arguments[0].scrollIntoView()", findElement(by));
    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by) {
        return findElement(by).getText();

    }

    public String getValue(By by) {
        return jsdriver.executeScript("return arguments[0].value;", findElement(by)).toString();



    }
    public void getClearAndWrite(By by,String arttrımAdedi){
        WebElement webElement =driver.findElement(by);
        webElement.sendKeys(Keys.chord(Keys.CONTROL,"A"),Keys.DELETE,arttrımAdedi);


    }
    public void addFavoritesRandom(int index){
        List<WebElement> productElements= driver.findElements(By.xpath("//div[@class='product-list']/div"));
        click(By.xpath("//div[@class='product-list']/div["+ index +"]/div[@class='grid_2 alpha omega relative']/div[@class='hover-menu']/a[@class='add-to-favorites']"));
    }
    public By listUnit(int index){
        List<WebElement> productElements= driver.findElements(By.xpath("//div[@class='product-list']/div"));
        return (By.xpath("//div[@class='product-list']/div["+ index +"]"));

    }
}





