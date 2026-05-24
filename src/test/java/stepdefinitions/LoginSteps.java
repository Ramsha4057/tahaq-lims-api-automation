package stepdefinitions;

import api.AuthAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.LoginPayload;
import testcontext.TestContext;
import utils.TokenManager;
import validations.LoginValidation;

public class LoginSteps {

    Response response;

    @Given("user login with valid credentials")
    public void user_login_with_valid_credentials() {

        response = AuthAPI.login(LoginPayload.validLoginPayload());

        // TOKEN EXTRACTION
        String token = response.jsonPath().getString("data.token");

        // STORE TOKEN
        TokenManager.setToken(token);
        TestContext.set("token", token);
    }

    @Given("user login with invalid credentials")
    public void user_login_with_invalid_credentials() {

        response = AuthAPI.login(LoginPayload.invalidLoginPayload());
    }

    @Then("login response status code should be {int}")
    public void login_response_status_code_should_be(int expectedStatusCode) {

        LoginValidation.validateStatusCode(response, expectedStatusCode);
    }

    @Then("login response should contain token")
    public void login_response_should_contain_token() {

        LoginValidation.validateToken(response);
    }

    @Then("login response should contain error message")
    public void login_response_should_contain_error_message() {

        LoginValidation.validateErrorMessage(response);
    }
}