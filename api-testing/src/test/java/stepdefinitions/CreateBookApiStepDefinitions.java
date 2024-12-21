package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class CreateBookApiStepDefinitions extends TestBase {
    private Response response;

    @Given("admin is authenticated")
    public void admin_is_authenticated() {
        RequestSpecification adminRequest1 = TestBase.adminRequest;// Auth is already configured
    }

    @Given("user is authenticated")
    public void user_is_authenticated() {
        RequestSpecification userRequest1 = TestBase.userRequest;// Auth is already configured
    }

    @When("user sends a POST request to {string} with the following data:")
    public void user_sends_post_request_with_data(String endpoint,String author, String title) {
        String data = String.format("{ \"title\": \"%s\", \"author\": \"%s\" }", title, author);
        response = userRequest.body(data).post(endpoint);
    }

    @When("user sends a POST request to {string} with invalid data:")
    public void user_sends_post_request_with_invalid_data(String endpoint,String author, String title) {
        String data = String.format("{ \"title\": \"%s\", \"author\": \"%s\" }", title, author);
        response = userRequest.body(data).post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
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

    @And("the response should contain a {string}")
    public void response_message_should_indicate(String message) {
        Assert.assertTrue(response.getBody().asString().contains(message), "Unexpected response message");
    }

}