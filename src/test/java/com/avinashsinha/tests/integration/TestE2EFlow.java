package com.avinashsinha.tests.integration;

import com.avinashsinha.asserts.AssertActions;
import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestE2EFlow extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestE2EFlow.class);

    @Test(groups = "QA", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Create the Author")
    public void testCreateAuthors_POST() {

        LOGGER.info("Start the Author Creation");

        // 1) build payload (can be dynamic or default)
        String payload = payloadManager.createAuthorRequest();

        // 2) send request
        response = RestAssured.given(requestSpecification)
                .body(payload)
                .when().log().all()
                .post();

        // 3) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

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

        LOGGER.info("Complete the Author Creation");

    }

    @Test(groups = "QA", priority = 2)
    @Owner("Avinash Sinha")
    @Description("TC#2 : Step 2. Details of Authors")
    public void testDetailAuthors_GET() {

        LOGGER.info("Show the Details of All Authors");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .when().log().all()
                .get();

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println();

        LOGGER.info("End the Details of All Authors");

    }

    @Test(groups = "QA", priority = 3)
    @Owner("Avinash Sinha")
    @Description("TC#3 : Step 3. Details of Author By Id")
    public void testAuthorDetails_GET(ITestContext iTestContext) {

        int id_e = 86;

        LOGGER.info("Show the Details of Single Author by Id");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("id", id_e)
                .when().log().all()
                .get(APIConstants.ID);

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        // 3) use AssertActions for simple checks
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

        iTestContext.setAttribute("id", id);

        iTestContext.setAttribute("idBook", idBook);

        System.out.println();

        LOGGER.info("End the Details of Single Author by Id");

    }

    @Test(groups = "QA", priority = 4)
    @Owner("Avinash Sinha")
    @Description("TC#4 : Step 4. Details of Author Book By Id")
    public void testBookOfAuthor_GET(ITestContext iTestContext) {

        int idBook_e = (int) iTestContext.getAttribute("idBook");

        LOGGER.info("Show the Details of Author Book by Id");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("idBook", idBook_e)
                .when().log().all()
                .get(APIConstants.AUTHOR_BOOK_BY_ID);

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println();

        LOGGER.info("End the Details of Author Book by Id");

    }

    @Test(groups = "QA", priority = 5)
    @Owner("Avinash Sinha")
    @Description("TC#5 : Step 5. Full Update the Author By Id")
    public void testFullUpdateAuthor_PUT(ITestContext iTestContext) {

        int id_e = (int) iTestContext.getAttribute("id");

        LOGGER.info("Full Update the Author by Id");

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

        LOGGER.info("Complete the Full Updation");

    }

    @Test(groups = "QA", priority = 6)
    @Owner("Avinash Sinha")
    @Description("TC#6 : Step 6. Delete the Author By Id")
    public void testDeleteAuthorId_DELETE(ITestContext iTestContext) {

        int id_e = (int) iTestContext.getAttribute("id");

        LOGGER.info("Delete the Author by Id");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("id", id_e)
                .when().log().all()
                .delete(APIConstants.ID);

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println();

        LOGGER.info("Deletion is Done");

    }

}