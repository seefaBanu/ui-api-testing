package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Map;

public class CreateBookApiStepDefinitions extends TestBase {
    private Response response;


    @When("user sends a POST request to {string} with the following data:")
    public void user_sends_post_request_with_data(String endpoint,Map<String, String> data) {
        response = userRequest.body(data).post(endpoint);
    }

    @When("user sends a POST request to {string} with invalid data:")
    public void user_sends_post_request_with_invalid_data(String endpoint, Map<String, String> data ) {
        response = userRequest.body(data).post(endpoint);
    }

    @Then("the response for creating book api status code should be {int}")
    public void the_response_for_creating_book_api_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @Then("the response should contain book author details")
    public void response_should_contain_book_author_details() {
        Assert.assertTrue(response.getBody().asString().contains("author"), "Book details are missing in response");
    }

    @Then("the response should contain book title details")
    public void response_should_contain_book_title_details() {
        Assert.assertTrue(response.getBody().asString().contains("title"), "Book details are missing in response");
    }


    @When("un authenticated POST request to {string} with the following data:")
    public void user_sends_post_request_without_authentication(String endpoint, Map<String, String> data) {
        response = unAuthenticatedRequest.body(data).post(endpoint); // Sending the request without authentication
    }



//    @When("user sends a POST request to {string} with the following data:")
//    public void user_sends_post_request_with_empty_fields(String endpoint, Map<String, String> data) {
//        response = userRequest.body(data).post(endpoint); // Sending the request with empty fields
//    }
//
//
//
//    @When("user sends a POST request to {string} with the following data:")
//    public void user_sends_post_request_with_duplicate_title(String endpoint, Map<String, String> data) {
//        response = userRequest.body(data).post(endpoint); // Sending the request with duplicate title
//    }
//
//
//
//
//    @When("user sends a POST request to {string} with the following data:")
//    public void user_sends_post_request_with_invalid_author_type(String endpoint, Map<String, String> data) {
//        response = userRequest.body(data).post(endpoint); // Sending the request with invalid author type
//    }



}