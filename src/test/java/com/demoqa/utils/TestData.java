package com.demoqa.utils;

import com.demoqa.models.LoginBodyModel;
import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();

    public static String login = "user921",
            password = "User921!",
            isbn = getRandomIsbn();

    public static LoginBodyModel credentials = new LoginBodyModel(login, password);

    public static String getRandomIsbn() {
        String[] isbn = {"9781449325862", "9781449331818", "9781449337711",
                "9781449365035", "9781491904244", "9781491950296",
                "9781593275846", "9781593277574"};

        return faker.options().option(isbn);
    }

}
