package com.demoqa.api;

import com.demoqa.models.LoginBodyModel;
import com.demoqa.models.LoginResponseModel;

import static com.demoqa.specs.AuthSpec.authRequestSpec;
import static com.demoqa.specs.AuthSpec.authResponseSpec;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {

    public static LoginResponseModel login(LoginBodyModel credentials) {

        return given(authRequestSpec)
                .body(credentials)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(authResponseSpec)
                .extract().as(LoginResponseModel.class);

    }

}
