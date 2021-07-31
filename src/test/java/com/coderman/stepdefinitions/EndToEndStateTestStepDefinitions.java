package com.coderman.stepdefinitions;

import com.coderman.pojo.Country;
import com.coderman.pojo.State;
import com.coderman.pojo.UpdateState;
import com.coderman.util.Specs;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/*
*
* "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
*
* */


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EndToEndStateTestStepDefinitions {
    Response response;
    int stateId;
    Country country;
    State state;

//    RequestSpecification requestSpecification = Specs.createRequestSpec();
    RequestSpecification requestSpecification;

    @Before
    public void init(){

        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("team46admin");
        authScheme.setPassword("Team46admin.");

        requestSpecification =   new RequestSpecBuilder()
                                    .setBaseUri("https://gmibank-qa-environment.com/api/")
                                    .setContentType("application/json")
                                    .setAuth(authScheme)
                                    .build();
    }




    @Given("send post request to create a state")
    public void sendPostRequestToCreateAState() {

        country = new Country();
        country.setId(22347);
        country.setName("KENYA");

        state = new State();
        state.setName("Nevada");
        state.setTpcountry(country);

        response =
                    given().
                            spec(requestSpecification).
                    when().
                            body(state).
                            post("https://gmibank-qa-environment.com/api/tp-states");

        stateId = response.then().extract().path("id");
        response.prettyPrint();
    }

    @And("send a get request to ensure that state is created")
    public void sendAGetRequestToEnsureThatStateIsCreated() {

        given().
               pathParam("id",stateId).
                spec(requestSpecification).
        when().
                get("https://gmibank-qa-environment.com/api/tp-states/{id}").
        then().
                spec(Specs.createResponseSpec());
    }

    @And("send a put request to update the state")
    public void sendAPutRequestToUpdateTheState() {


        UpdateState updateState = new UpdateState();
        updateState.setId(stateId);
        updateState.setName("Arizona");

        given().
                spec(requestSpecification).
        when().
                body(updateState).
                put("https://gmibank-qa-environment.com/api/tp-states")
                .then().log().all().statusCode(200);
    }

    @And("send a delete request to delete the state")
    public void sendADeleteRequestToDeleteTheState() {

        given().
                pathParam("id",stateId).
                spec(requestSpecification).
        when().
                delete("https://gmibank-qa-environment.com/api/tp-states/{id}")
                .then().statusCode(204);
    }

    @And("send a get request again to make sure the state is deleted")
    public void sendAGetRequestAgainToMakeSureTheStateIsDeleted() {

        given().
                pathParam("id",stateId).
                spec(requestSpecification).
        when().
                get("https://gmibank-qa-environment.com/api/tp-states/{id}")
        .then().statusCode(404);

    }
}
