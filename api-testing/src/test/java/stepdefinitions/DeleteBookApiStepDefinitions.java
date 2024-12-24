package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class DeleteBookApiStepDefinitions extends TestBase {
    private Response response;

    @Given("admin is authenticated")
    public void admin_is_authenticated() {
        // Use adminRequest as authenticated request
        RequestSpecification adminRequest1 = TestBase.adminRequest;
    }

    @When("admin sends a DELETE request to {string} with ID {int}")
    public void admin_sends_delete_request_with_id(String endpoint, int id) {
        String fullEndpoint = endpoint.replace("{id}", String.valueOf(id));
        response = TestBase.adminRequest.delete(fullEndpoint);
    }

    @Then("the response status code should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @Then("the response should indicate book deletion with message {string}")
    public void response_should_indicate_book_deletion_with_message(String message) {
        Assert.assertTrue(response.getBody().asString().contains(message), "Expected message not found in response!");
    }

    @And("the response body should not contain details of deleted book with ID {int}")
    public void response_body_should_not_contain_details_of_deleted_book(int id) {
        Assert.assertFalse(response.getBody().asString().contains(String.valueOf(id)), "Deleted book details are still present in response!");
    }

    @When("user sends a DELETE request to {string} with ID {int}")
    public void user_sends_delete_request_with_id(String endpoint, int id) {
        String fullEndpoint = endpoint.replace("{id}", String.valueOf(id));
        response = TestBase.userRequest.delete(fullEndpoint);
    }

    @Then("the response status code for unauthorized access should be {int}")
    public void response_status_code_for_unauthorized_access_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unauthorized user is able to delete!");
    }
}
