package com.coderman.stepdefinitions;

import com.coderman.pojo.RequestUser;
import com.coderman.pojo.ResponseUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PostRequestStepDefinitions {

    Response response;
    @Given("send post request using the api {string}")
    public void sendPostRequestUsingTheApi(String api) throws FileNotFoundException {

//        //given
//        response =RestAssured.given().contentType("application/json")
//        //when
//        .when().body("{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}").post(api);

        // interface e gore kod yazmak.
//        Map<String,String> map = new HashMap<>();
//        map.put("name","fatma");
//        map.put("job","IT");
//
//
//        //given
//        response =RestAssured.given().contentType("application/json")
//                //when
//                .when().body(map).post(api);
//        response.prettyPrint();


//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name","ahmet");
//        jsonObject.put("job","HR");
//
//        //given
//        response =RestAssured.given().contentType("application/json")
//                //when
//                .when().body(jsonObject.toString()).post(api);
//        response.prettyPrint();


//        //File okuyarak data gondermek
//        File file = new File("/Users/coderman/Desktop/QAProjects/ApiStudyProject/src/test/resources/data/BodyWithVariables.json");
//        FileReader fileReader = new FileReader(file);
//        JSONTokener jsonTokener = new JSONTokener(fileReader);
//        JSONObject jsonObject = new JSONObject(jsonTokener);
//
//        String data = jsonObject.toString();
//        data = data.replace("{{id}}","Scott");
//        data = data.replace("{{job}}","Developer");
//
//
//        //given
//        response =RestAssured.given().contentType("application/json")
//                //when
//                .when().body(data).post(api);
//        response.prettyPrint();


        RequestUser requestUser = new RequestUser("Zulkuf","Art");

        //given
        response =RestAssured.given().contentType("application/json")
                //when
                .when().body(requestUser).post(api);
        response.prettyPrint();
    }

    @Then("verify statusCode")
    public void verifyStatusCode() {
//        response.then().assertThat().statusCode(201);
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(201,response.statusCode());
    }

    @And("verify server in header")
    public void verifyServerInHeader() {
        Assert.assertEquals("cloudflare",response.header("server"));
    }

    @And("verify the user")
    public void verifyTheUser() {

//        response.then().body("name", Matchers.equalTo("Zulkuf"));
//        response.then().body("job", Matchers.equalTo("Art"));

//
//        Assert.assertEquals("Zulkuf", response.then().extract().path("name"));
//        Assert.assertEquals("Art",response.then().extract().path("job"));
//
//
//        JsonPath jsonPath = response.jsonPath();
//        String actualName = jsonPath.getString("name");
//        String actualJob = jsonPath.getString("job");
//
//
//        Assert.assertEquals("Zulkuf",actualName);
//        Assert.assertEquals("Art",actualJob);


//        String responseUserName  = response.then().extract().as(ResponseUser.class).getName();

        ResponseUser responseUser = response.then().extract().as(ResponseUser.class);

        Assert.assertEquals("Zulkuf", responseUser.getName());
        Assert.assertEquals("Art",responseUser.getJob());

        // Chaining - Zincirleme - end-to-end

        String userId = responseUser.getId();


        Response getRequestResponse = RestAssured.given().contentType("application/json")
                .when().get("https://reqres.in/api/users/" + 2);

        getRequestResponse.prettyPrint();

    }
}
