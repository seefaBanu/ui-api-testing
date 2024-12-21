package stepdefinitions;

import base.TestBase;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;

public class GetBooksApiStepDefinitions extends TestBase {
    private Response response;

    @Given("admin is authenticated")
    public void admin_is_authenticated() {
        RequestSpecification adminRequest1 = TestBase.adminRequest;// Auth is already configured
    }

    @Given("user is authenticated")
    public void user_is_authenticated() {
        RequestSpecification userRequest1 = TestBase.userRequest;// Auth is already configured
    }

}