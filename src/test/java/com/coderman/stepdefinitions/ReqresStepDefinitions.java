package com.coderman.stepdefinitions;

import com.coderman.pojo.Data;
import com.coderman.pojo.JavaResponse;

import com.coderman.pojo.JavaUsersResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;


public class ReqresStepDefinitions {

    Response response;
    JavaResponse javaResponse;
    JavaUsersResponse javaUsersResponse;

//    @Given("send get request using the reqres api")
//    public void sendGetRequestUsingTheReqresApi() {
//        baseURI = "https://reqres.in/api/";
//
//        //given = precondition
//        //when   - action - send request
//        //when  - response
//        response = given().contentType("application/json")
//                .when().get("users/2");
//
//        response.prettyPrint();
//
//    }
//
//    @Then("verify the single user")
//    public void verifyTheSingleUser() {
//        // First approach - using assethat.body()
////        response.then().assertThat().body("data.first_name", equalTo("Janet"),
////                "data.last_name",equalTo("Weaver"),
////                "data.email",equalTo("janet.weaver@reqres.in"),
////                "data.id",equalTo(2));
//
//        //Second approach - using json path
//        JsonPath jsonPath = response.jsonPath();
//        String firstname = jsonPath.getString("data.first_name");
//
//        Assert.assertEquals("Janet", firstname);
//    }

    @Given("send get request using the reqres api {string}")
    public void sendGetRequestUsingTheReqresApi(String endpoint) {
//        baseURI = "https://reqres.in/api/";
         javaUsersResponse = given().contentType("application/json").log().all()
                .when().get("https://reqres.in/api/users?page=2").then().extract().as(JavaUsersResponse.class);

        System.out.println(javaUsersResponse);
    }


    @Then("verify the single user's firstName {string}")
    public void verifyTheSingleUserSFirstName(String expectedFirstName) {
//        JsonPath jsonPath = response.jsonPath();
//        String firstname = jsonPath.getString("data.first_name");
//        Assert.assertEquals(expectedFirstName, firstname);

//        Assert.assertEquals(expectedFirstName,javaResponse.getData().getFirst_name());
//        Assert.assertEquals("https://reqres.in/#support-heading",javaResponse.getSupport().getUrl());

    }

    @Then("verify some users")
    public void verifySomeUsers() {
        //test data
//        List<Data> expectedUserList = new ArrayList<>();
//        expectedUserList.add(new Data(10,"byron.fields@reqres.in","Byron","Fields","https://reqres.in/img/faces/10-image.jpg"));
////        expectedUserList.add(new Data(11,"george.edwards@reqres.in","George","Edwards","https://reqres.in/img/faces/11-image.jpg"));
//
//        List<Data> actualUserList = javaUsersResponse.getData();
//        Assert.assertTrue(actualUserList.containsAll(expectedUserList));

    }
}

/*
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
*
* {
*        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
* }
*

    a
    b
    c = a+b
    c






* */