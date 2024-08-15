package com.demoqa.api;

import com.demoqa.models.CollectionBodyModel;
import com.demoqa.models.LoginResponseModel;

import static com.demoqa.specs.BooksSpec.*;
import static io.restassured.RestAssured.given;

public class BookApi {

    public static void addBook(LoginResponseModel loginResponse, CollectionBodyModel bookData) {

        given(booksRequestSpec)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(bookData)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(addBookResponseSpec);

    }

    public static void deleteAllBooks(LoginResponseModel loginResponse) {

        given(booksRequestSpec)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParams("UserId", loginResponse.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(deleteBookResponseSpec);

    }

}
