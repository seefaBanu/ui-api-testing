package stepdefinitions;

import base.TestBase;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookApiStepDefinitions extends TestBase {
    private Response response;

    @Given("admin is authenticated")
    public void admin_is_authenticated() {
        RequestSpecification adminRequest1 = TestBase.adminRequest;// Auth is already configured
    }

    @Given("user is authenticated")
    public void user_is_authenticated() {
        RequestSpecification userRequest1 = TestBase.userRequest;// Auth is already configured
    }

    @When("admin sends a GET request to {string}")
    public void admin_sends_get_request(String endpoint) {
        response = adminRequest.get(endpoint);
    }

    @When("user sends a GET request to {string}")
    public void user_sends_get_request(String endpoint) {
        response = userRequest.get(endpoint);
    }

    @When("user sends a POST request to {string} with the following data:")
    public void user_sends_post_request_with_data(String endpoint, Map<String, String> data) {
        response = userRequest.body(data).post(endpoint);
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

    @Then("the response message should indicate {string}")
    public void response_message_should_indicate(String message) {
        Assert.assertTrue(response.getBody().asString().contains(message), "Unexpected response message");
    }
}
