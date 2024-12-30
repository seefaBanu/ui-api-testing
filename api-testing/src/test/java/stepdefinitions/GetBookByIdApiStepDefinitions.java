package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class GetBookByIdApiStepDefinitions extends TestBase {

    private Response response;
    private RequestSpecification request;

    @Given("user is authenticated")
    public void user_is_authenticated() {
        request = TestBase.userRequest(); // Authenticated request
    }

    @Given("the endpoint {string}")
    public void the_endpoint(String endpoint) {
        request = TestBase.baseRequest().basePath(endpoint);
    }

    @Given("no authentication header is provided")
    public void no_authentication_header_is_provided() {
        request = TestBase.baseRequest(); // No authentication header
    }

    @When("user sends a GET request to {string}")
    public void user_sends_a_get_request_to(String endpoint) {
        response = request.when().get(endpoint);
    }

    @When("a GET request is sent")
    public void a_get_request_is_sent() {
        response = request.when().get();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals("Status code mismatch", statusCode, response.getStatusCode());
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
}
