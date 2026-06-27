package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestAuthorsDetails extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestAuthorsDetails.class);

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Details of Authors")
    public void testDetailAuthors_GET() {

        LOGGER.info("Send the API Request");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .when().log().all()
                .get();

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println();

        LOGGER.info("End the API Request");

    }
}