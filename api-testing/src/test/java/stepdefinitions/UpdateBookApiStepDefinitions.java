package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;


import java.util.HashMap;
import java.util.Map;
public class UpdateBookApiStepDefinitions extends TestBase {
    private Response response;

    @When("{string} sends a PUT request to {string} with the following valid data:")
    public void admin_sends_put_request_with_valid_data(String user, String endpoint, Map<String, String> data) {
        Map<String, String> mutableData = new HashMap<>(data);
        mutableData.replaceAll((key, value) -> "empty string".equalsIgnoreCase(value) ? "" : value);

        if (user.equals("user")) {
            response = TestBase.userRequest
                    .body(mutableData)
                    .put(endpoint);
        } else if (user.equals("admin")) {
            response = TestBase.adminRequest
                    .body(mutableData)
                    .put(endpoint);
        } else {
            throw new IllegalArgumentException("Invalid user type: " + user);
        }
    }

    @Then("the response status code for Updating Book API should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @And("the response body for Update Book API should be {string}")
    public void the_response_body_for_update_book_api_should_be(String expectedMessage) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedMessage), "Response body does not contain expected message: " + expectedMessage);
    }
}