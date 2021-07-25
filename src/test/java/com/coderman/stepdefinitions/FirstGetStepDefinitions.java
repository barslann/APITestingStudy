package com.coderman.stepdefinitions;

import com.coderman.pojo.BookingModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured.*;
import  io.restassured.matcher.RestAssuredMatchers.*;
import   org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;


public class FirstGetStepDefinitions {
    Response response;
    BookingModel bookingModel;
    @Given("send get request using the api {string}")
    public void sendGetRequestUsingTheApi(String api) {


        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath="/api";


        response = given().contentType("application/json")
        .when().get("/user/2").then().extract().response();



        response.prettyPrint();

    }

    @Then("verify firstName")
    public void verifyFirstName() {

        response.then().assertThat().body("data.id", Matchers.equalTo(2));
        // expected, actual
//        Assert.assertEquals("Eric",bookingModel.getFirstname());
//
//        JsonPath  jsonPath = response.jsonPath();
//        String firstName = jsonPath.getString("data.name");
//        Map<String,String> list = jsonPath.getMap("$");
//
//        Assert.assertEquals(firstName,"fuchsia rose");

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
*
*
*
*
* Agenda

    reqres.in apis
    base uri
    base path

    Get request to get single user
        -Assertion
            1. approach
            asserthat.body()

            2. approach json path
                jsonpath

            3.Pojo
                Java class


    Get request to get all user
    Get request single user not found

    crating pojo class for complex json
*
* */


