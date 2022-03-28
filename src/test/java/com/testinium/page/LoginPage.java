package com.testinium.page;


import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Methods methods;

    public LoginPage() {
        methods = new Methods();
    }

    public void login() {
        methods.click(By.cssSelector(".menu-top-button.login>a"));
        methods.click(By.cssSelector("input#login-email"));
        methods.sendKeys(By.id("login-email"), "mucahitselcuk25@gmail.com");
        methods.click(By.cssSelector(".popupContainer.show>div[class='popupCloseIcon']"));
        methods.sendKeys(By.id("login-password"), "hesap123");
        methods.click(By.cssSelector("button[role=button]"));
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".attention")));
    }


}