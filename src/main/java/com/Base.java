package com;
import com.codeborne.selenide.SelenideElement;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static io.restassured.http.ContentType.JSON;

public class Base {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";

    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}
