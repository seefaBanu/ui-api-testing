package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class GetBooksApiStepDefinitions extends TestBase {
    private Response response;

    @When("admin sends a GET request to {string}")
    public void admin_sends_get_request(String endpoint) {
        response = adminRequest.get(endpoint);
    }

    @When("user sends a GET request to {string}")
    public void user_sends_get_request(String endpoint) {
        response = userRequest.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @Then("the response should contain a list of books")
    public void response_should_contain_list_of_books() {
        Assert.assertTrue(response.getBody().asString().contains("title"), "Book list is missing in response");
    }

    @Then("the response should contain book details")
    public void response_should_contain_book_details() {
        Assert.assertTrue(response.getBody().asString().contains("author"), "Book details are missing in response");
    }

    @Then("the response should indicate no books exist")
    public void the_response_should_indicate_no_books_exist() {
        String responseBody = response.getBody().asString();
        // Adjust this based on the actual response
        Assert.assertTrue(responseBody.contains("[]"), "Expected message indicating no books exist was not found!");
    }

    @And("the response should contain an error message")
    public void the_response_should_contain_an_error_message() {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Invalid query parameter"), "Expected error message not found!");
    }
}
