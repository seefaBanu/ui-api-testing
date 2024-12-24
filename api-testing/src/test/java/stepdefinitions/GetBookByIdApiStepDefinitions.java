package stepdefinitions;

import base.TestBase;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;

public class GetBookByIdApiStepDefinitions extends TestBase {
    private Response response;

    @Given("admin is authenticated")
    public void admin_is_authenticated() {
        RequestSpecification adminRequest1 = TestBase.adminRequest;// Auth is already configured
    }

    @Given("user is authenticated")
    public void user_is_authenticated() {
        RequestSpecification userRequest1 = TestBase.userRequest;// Auth is already configured
    }

    @When("user sends a GET request to {string}")
    public void user_sends_get_request(String endpoint) {response = TestBase.userRequest.get(endpoint);}

    @Then("the response status code should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }
    @Then("the response should contain book details")
    public void response_should_contain_book_details() {
        Assert.assertTrue(response.getBody().asString().contains("title"), "Book title is missing in response");
        Assert.assertTrue(response.getBody().asString().contains("author"), "Book author is missing in response");
    }

    @Then("the response should contain an error message")
    public void response_should_contain_error_message() {
        Assert.assertTrue(response.getBody().asString().contains("error"), "Error message is missing in response");
    }
}