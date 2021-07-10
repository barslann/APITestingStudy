package com.coderman.stepdefinitions;

import com.coderman.pojo.BookingModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;


public class FirstGetStepDefinitions {
    Response response;
    BookingModel bookingModel;
    @Given("send get request using the api {string}")
    public void sendGetRequestUsingTheApi(String api) {

        bookingModel = given().contentType("application/json")
        .when().get(api).then().log().all().extract().as(BookingModel.class);
        System.out.println(bookingModel);

    }

    @Then("verify firstName")
    public void verifyFirstName() {
        // expected, actual
        Assert.assertEquals("Eric",bookingModel.getFirstname());

//        response.then().assertThat().body("firstname", equalTo("Jim"));
//        JsonPath  jsonPath = response.jsonPath();
//        jsonPath.

//        response.then().assertThat().statusLine("HTTP/1.2 200 OK");
    }

    @And("verify lastname")
    public void verifyLastname() {
//        response.then().assertThat().body("lastname", equalTo("Wilson"));

    }
}


/*
*  log all request
*   log all response
*   send request using request
*   then status code check
* 
*
*
* */