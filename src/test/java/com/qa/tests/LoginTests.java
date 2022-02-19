package com.qa.tests;

import base.BaseTest;
import org.testng.Assert;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    public void invalidUserName() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressLoginBtn();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginBtn();
    }

    @Test(priority = 2)
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
        loginPage.pressLoginBtn();
    }

    @Test(priority = 3)
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
        loginPage.pressLoginBtn();
    }
}
