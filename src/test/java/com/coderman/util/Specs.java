package com.coderman.util;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class Specs {

    public static RequestSpecification createRequestSpec(){
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("team46admin");
        authScheme.setPassword("Team46admin.");

        return  new RequestSpecBuilder()
                .setBaseUri("https://gmibank-qa-environment.com/api/")
                .setContentType("application/json")
                .setAuth(authScheme)
                .build();
    }

    public static ResponseSpecification createResponseSpec(){
        return new ResponseSpecBuilder().
                expectContentType("application/json").
                expectStatusCode(200).
                expectBody("name", Matchers.equalTo("Nevada")).build();
    }


}
