package stepdefinitions;

import com.itqa.pages.MyAccount;
import com.itqa.pages.RegisterPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class RegisterSteps {

    // Instantiate the RegisterPage using the driver from DriverFactory
    RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
    MyAccount myAccount = new MyAccount(DriverFactory.getDriver());

    // Navigate to the Create Account page
    @When("I go to Create an Account page")
    public void iGoToTheCreateAccountPage() {
        registerPage.goToCreateAccountPage();
    }

    // Fill in the registration form with data from the DataTable
    @When("I fill in the registration form with valid details")
    public void iFillInTheRegistrationFormWithValidDetails(DataTable dataTable) {
        // Extract data from the Cucumber DataTable
        List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = formData.get(0); // Assuming a single row for now
        String dynamicEmail = "user_" + System.currentTimeMillis() + "@testmail.com";

        // Fill each field using the extracted data
        registerPage.setFirstName(data.get("first_name"));
        registerPage.setLastName(data.get("last_name"));
        registerPage.setEmail(dynamicEmail);
        registerPage.setPassword(data.get("password"));
        registerPage.setConfirmPassword(data.get("confirm_password"));
    }

    // Submit the registration form
    @When("I click Create an Account Button")
    public void iClickCreateAnAccountButton() {
        registerPage.submitForm();
    }

    @Then("successfully created new account message should be {string}")

    public void successful_message_should_be(String message) {
        assertEquals(message, myAccount.getSuccessMessage());
    }


}
