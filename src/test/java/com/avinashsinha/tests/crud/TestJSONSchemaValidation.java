package com.avinashsinha.tests.crud;

import com.avinashsinha.asserts.AssertActions;
import com.avinashsinha.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestJSONSchemaValidation extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestJSONSchemaValidation.class);

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. JSON Schema Validation")
    public void testJSONSchemaValidation_POST() {

        LOGGER.info("Build Payload and Send the API Request");

        // 1) build payload (can be dynamic or default)
        String payload = payloadManager.createAuthorJSONSchemaRequest();

        // 2) send request
        response = RestAssured.given(requestSpecification)
                .body(payload)
                .when().log().all()
                .post();

        // 3) basic status code validation and JSON Schema Validation
        validatableResponse = response.then().log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/author_create_schema.json"));

        // 4) use AssertActions for simple checks
        assertActions = new AssertActions(response);

        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        int id = response.jsonPath().getInt("id");
        System.out.println("Id          : " + id);
        assertActions.verifyAuthorIdNotNull();

        int idBook = response.jsonPath().getInt("idBook");
        System.out.println("Book Id     : " + idBook);
        assertActions.verifyBookIdNotNull();

        String firstName = response.jsonPath().getString("firstName");
        System.out.println("First Name  : " + firstName);
        assertActions.verifyFirstNameNotBlank();

        String lastName = response.jsonPath().getString("lastName");
        System.out.println("Last Name   : " + lastName);
        assertActions.verifyLastNameNotEmpty();

        System.out.println();

        LOGGER.info("End the API Request and assertions");

    }

}