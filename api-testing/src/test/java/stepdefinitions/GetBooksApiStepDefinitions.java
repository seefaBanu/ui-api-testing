package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetBooksApiStepDefinitions extends TestBase {
    private Response response;

    @When("admin sends a GET request to {string}")
    public void admin_sends_get_request_to(String endpoint) {
        response = TestBase.adminRequest.get(endpoint);
    }

    @When("user sends a GET request to {string}")
    public void user_sends_get_request_to(String endpoint) {
        response = TestBase.userRequest.get(endpoint);
    }

    @Then("The response status code for GET Books API should be {int}")
    public void the_get_response_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @And("the response should contain a list of books")
    public void the_response_should_contain_a_list_of_books() {
        Assert.assertTrue(response.getBody().asString().contains("title"), "Book list is missing in the response!");
    }

    @And("the response should indicate no books available")
    public void the_response_should_indicate_no_books_available() {
        Assert.assertTrue(response.getBody().asString().contains("No books available"), "Expected 'No books available' message is missing!");
    }

    @When("admin sends a GET request to {string} with invalid query parameters")
    public void admin_sends_get_request_with_invalid_query_parameters(String endpoint) {
        response = TestBase.adminRequest.get(endpoint);
    }

    @And("the response should indicate an invalid query parameter error")
    public void the_response_should_indicate_invalid_query_parameter_error() {
        Assert.assertTrue(response.getBody().asString().contains("Invalid query parameter"), "Expected error message for invalid query parameter is missing!");
    }


}