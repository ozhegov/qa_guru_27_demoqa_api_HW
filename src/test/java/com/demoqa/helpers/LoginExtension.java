package com.demoqa.helpers;

import com.demoqa.api.AuthorizationApi;
import com.demoqa.models.LoginResponseModel;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.demoqa.utils.TestData.credentials;

public class LoginExtension implements BeforeEachCallback {


    @Override
    public void beforeEach(ExtensionContext extensionContext) {

        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
    }

}
