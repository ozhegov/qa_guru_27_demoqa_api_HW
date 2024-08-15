package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import com.demoqa.api.AuthorizationApi;
import com.demoqa.api.BookApi;
import com.demoqa.helpers.WithLogin;
import com.demoqa.models.CollectionBodyModel;
import com.demoqa.models.IsbnModel;
import com.demoqa.models.LoginResponseModel;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.utils.TestData.credentials;
import static com.demoqa.utils.TestData.getRandomIsbn;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("regression")
@Owner("Maksim Ozhegov")
@DisplayName("Проверки удаления книг из коллекции")
public class DeleteBookTests extends TestBase {

    LoginResponseModel loginResponse = AuthorizationApi.login(credentials);

    @Test
    @WithLogin
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("После удаления книг из коллекции по кнопке 'Delete All Books' список коллекции пустой")
    void booksAreNoVisibleAfterDeleteAllBooksFromCollection() {

        step("Удаляем все книги из коллекции", () -> {
            BookApi.deleteAllBooks(loginResponse);
        });

        IsbnModel isbn = new IsbnModel(getRandomIsbn());
        List<IsbnModel> collectionOfIsbns = List.of(isbn);
        CollectionBodyModel bookData = new CollectionBodyModel(loginResponse.getUserId(), collectionOfIsbns);

        step("Добавляем книгу в коллекцию", () -> {
            BookApi.addBook(loginResponse, bookData);
        });

        step("Открываем страницу профиля", () -> {
            open("/profile");
        });

        step("Убираем рекламные баннеры", () -> {
            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");
            executeJavaScript("$('[id*=\"Ad.Plus-\"]').remove();");
        });

        step("Нажимаем на кнопку 'Delete All Books'", () -> {
            $$("#submit").findBy(text("Delete All Books")).click();
        });

        step("Подтверждаем удаление", () -> {
            $("#closeSmallModal-ok").click();
        });

        step("Закрываем поп-ап с алертом", () -> {
            Selenide.confirm();
        });

        step("Проверяем, что список коллекции пустой", () -> {
            $(".ReactTable").shouldHave(text("No rows found"));
        });

    }

    @Test
    @WithLogin
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("При попытке удаления коллекции без книг по кнопке 'Delete All Books' отображается алерт с предупреждающим текстом")
    void alertNoBooksIsVisibleAfterDeleteCollectionWithNoBooks() {

        step("Удаляем все книги из коллекции", () -> {
            BookApi.deleteAllBooks(loginResponse);
        });

        step("Открываем страницу профиля", () -> {
            open("/profile");
        });

        step("Убираем рекламные баннеры", () -> {
            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");
            executeJavaScript("$('[id*=\"Ad.Plus-\"]').remove();");
        });

        step("Нажимаем на кнопку 'Delete All Books'", () -> {
            $$("#submit").findBy(text("Delete All Books")).click();
        });

        step("Подтверждаем удаление", () -> {
            $("#closeSmallModal-ok").click();
        });

        step("Проверяем, что поп-ап с алертом содержит текст 'No books available in your's collection!'", () -> {
            String alertText = Selenide.switchTo().alert().getText();
            assertThat(alertText).isEqualTo("No books available in your's collection!");
        });

    }

    @Test
    @WithLogin
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("После удаления книги из коллекции отображается поп-ап с текстом 'Book deleted'")
    void alertBookDeletedIsVisibleAfterDeleteOneBook() {

        step("Удаляем все книги из коллекции", () -> {
            BookApi.deleteAllBooks(loginResponse);
        });

        IsbnModel isbn = new IsbnModel(getRandomIsbn());
        List<IsbnModel> collectionOfIsbns = List.of(isbn);
        CollectionBodyModel bookData = new CollectionBodyModel(loginResponse.getUserId(), collectionOfIsbns);

        step("Добавляем книгу в коллекцию", () -> {
            BookApi.addBook(loginResponse, bookData);
        });

        step("Открываем страницу профиля", () -> {
            open("/profile");
        });

        step("Убираем рекламные баннеры", () -> {
            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");
            executeJavaScript("$('[id*=\"Ad.Plus-\"]').remove();");
        });

        step("Нажимаем на кнопку 'Delete All Books'", () -> {
            $("#delete-record-undefined").click();
        });

        step("Подтверждаем удаление", () -> {
            $("#closeSmallModal-ok").click();
        });

        step("Проверяем, что поп-ап с алертом содержит текст 'Book deleted.'", () -> {
            String alertText = Selenide.switchTo().alert().getText();
            assertThat(alertText).isEqualTo("Book deleted.");
        });


    }


}
