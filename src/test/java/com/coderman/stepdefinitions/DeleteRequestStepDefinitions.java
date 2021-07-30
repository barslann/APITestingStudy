package com.coderman.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class DeleteRequestStepDefinitions {

    Response response;
    @Given("send delete request using the api {string}")
    public void sendDeleteRequestUsingTheApi(String url) {
        response =given().
                  when().
                        delete(url);
    }


    @And("statusCode must be {int}")
    public void statuscodeMustBe(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
