package com.coderman.stepdefinitions;

import com.coderman.pojo.RequestUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequestStepDefinitions {

    Response response;
    RequestUser user;

    @Given("send put request using the api {string}")
    public void sendPutRequestUsingTheApi(String url) {

        user = new RequestUser("mehmet","IT");

        response =
                given().
                contentType("application/json").
        when().
                body(user).
                put(url);

    }

    @And("verify updated user firstName")
    public void verifyUpdatedUserFirstName() {
//        Assert.assertEquals("ahmet",response.jsonPath().get("name"));
//        Assert.assertEquals("ahmet",response.then().extract().path("name"));
        Assert.assertEquals(user.getName(),response.then().extract().path("name"));
    }

    @And("verify updated user job")
    public void verifyUpdatedUserJob() {
//        Assert.assertEquals("IT",response.then().extract().path("job"));
        Assert.assertEquals(user.getJob(),response.then().extract().path("job"));
    }

    @And("verify update request statusCode")
    public void verifyUpdateRequestStatusCode() {
        Assert.assertEquals(200,response.statusCode());
    }
}
