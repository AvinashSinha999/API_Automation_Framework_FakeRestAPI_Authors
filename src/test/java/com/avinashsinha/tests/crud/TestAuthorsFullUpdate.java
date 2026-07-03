package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAuthorsFullUpdate extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestAuthorsFullUpdate.class);

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Full Update the Author By Id")
    public void testFullUpdateAuthor_PUT() {

        int id_e = 100;

        LOGGER.info("Build Payload and Send the API Request");

        // 1) build payload (can be dynamic or default)
        String payload = payloadManager.fullUpdateAuthorRequest();

        // 2) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("id", id_e)
                .body(payload)
                .when().log().all()
                .put(APIConstants.ID);

        // 3) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        // 4) use Assertions for simple checks
        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        int id = response.jsonPath().getInt("id");
        System.out.println("Id          : " + id);
        assertThat(id).isNotNull().isNotZero().isNotNegative();

        int idBook = response.jsonPath().getInt("idBook");
        System.out.println("Book Id     : " + idBook);
        assertThat(idBook).isNotNull().isNotZero().isNotNegative();

        String firstName = response.jsonPath().getString("firstName");
        System.out.println("First Name  : " + firstName);
        assertThat(firstName).isNotNull().isNotBlank().isNotEmpty();

        String lastName = response.jsonPath().getString("lastName");
        System.out.println("Last Name   : " + lastName);
        assertThat(lastName).isNotNull().isNotBlank().isNotEmpty();

        System.out.println();

        LOGGER.info("End the API Request and assertions");

    }
}