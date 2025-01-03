package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetBookByIdApiStepDefinitions extends TestBase {

    private Response response;

    @When("user sends a GET Book by ID request to {string}")
    public void user_sends_a_get_request_to(String endpoint) {
        response = userRequest.get(endpoint);
    }
    @When("admin sends a GET Book by ID request to {string}")
    public void admin_sends_a_get_request_to(String endpoint) {
        response = adminRequest.get(endpoint);
    }


    @Then("the response should contain book details")
    public void the_response_should_contain_book_details() {
        Assert.assertNotNull("Book title is missing", response.jsonPath().getString("title"));
        Assert.assertNotNull("Book author is missing", response.jsonPath().getString("author"));
    }

    @Then("the response should contain an error message")
    public void the_response_should_contain_an_error_message() {
        Assert.assertNotNull("Error message is missing", response.jsonPath().getString("error"));
    }

    @Then("the response body should contain an error message {string}")
    public void the_response_body_should_contain_an_error_message(String errorMessage) {
        Assert.assertEquals("Error message mismatch", errorMessage, response.jsonPath().getString("error"));
    }

    @Then("the response status code for GET book by ID API should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @And("the response should indicate book retrieve with message {string}")
    public void response_should_indicate_book_retrieve_with_message(String message) {
        Assert.assertTrue(response.getBody().asString().contains(message), "Expected message not found in response!");
    }

}