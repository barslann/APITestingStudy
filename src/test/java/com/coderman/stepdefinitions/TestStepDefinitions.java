package com.coderman.stepdefinitions;

import com.coderman.pojo.JavaUsersResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.junit.Assert;

public class TestStepDefinitions {
    JavaUsersResponse javaUsersResponse;
    @Given("send get request using  {string}")
    public void sendGetRequestUsing(String arg0) {

        javaUsersResponse = RestAssured.given().contentType("application/json")
                .when().get("https://reqres.in/api/users?page=2")
                .then().extract().as(JavaUsersResponse.class);

        System.out.println(javaUsersResponse);
    }

    @Then("verify users")
    public void verifyUsers() {
//        //test data
////        List<Data> expectedUserList = new ArrayList<>();
//        expectedUserList.add(new Data(10,"byron.fields@reqres.in","Byron","Fields","https://reqres.in/img/faces/10-image.jpg"));
//        expectedUserList.add(new Data(11,"george.edwards@reqres.in","George","Edwards","https://reqres.in/img/faces/11-image.jpg"));
//
//        List<Data> actualUserList = javaUsersResponse.getData();
//        Assert.assertTrue(actualUserList.containsAll(expectedUserList));

        Assert.assertEquals(6,javaUsersResponse.getData().size());

    }
}
