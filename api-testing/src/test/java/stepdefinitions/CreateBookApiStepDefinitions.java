package stepdefinitions;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Map;

public class CreateBookApiStepDefinitions extends TestBase {
    public Response response;


    @When("{string} sends a POST request to {string} with valid data:")
    public void user_sends_post_request_with_valid_data(String user, String endpoint, Map<String, String> data) {
        if (user.equals("user"))
            response = userRequest.body(data).post(endpoint);
        else if (user.equals("admin")){
            response = adminRequest.body(data).post(endpoint);
        }
    }

    @When("user sends a POST request to {string} with invalid data:")
    public void user_sends_post_request_with_invalid_data(String endpoint, Map<String, String> data ) {
        response = userRequest.body(data).post(endpoint);
    }

    @Then("the response for creating book api status code should be {int}")
    public void the_response_for_creating_book_api_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @When("user sends a POST request to {string} without mandatory field")
    public void user_sends_post_request_without_mandatory_field(String endpoint, Map<String, String> data) {
        response = userRequest.body(data).post(endpoint);
    }

    @Then("the response status code for Create Book API should be {int}")
    public void response_status_code_for_create_api_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @Then("the response should contain book author details")
    public void response_should_contain_book_author_details() {
        Assert.assertTrue(response.getBody().asString().contains("author"), "Book details are missing in response");
    }

    @Then("the response body for Create Book API should be {string}")
    public void response_body_for_create_api_should_be(int message) {
        Assert.assertEquals(response.getBody().asString(), message, "Unexpected status code!");
    }

    @After
    public void tearDown() {
        response = null;
    }


    @When("un authenticated POST request to {string} with the following data:")
    public void user_sends_post_request_without_authentication(String endpoint, Map<String, String> data) {
        response = unAuthenticatedRequest.body(data).post(endpoint); // Sending the request without authentication
    }


}
