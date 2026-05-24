package stepdefinitions;

import api.UserAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import payloads.UserPayload;
import testcontext.TestContext;
import validations.UserValidation;

public class UserSteps {

    Response response;

    @When("admin creates a new user with created role")
    public void admin_creates_a_new_user_with_created_role() {

        String roleId =
                TestContext.getString("roleId");

        response = UserAPI.createUser(
                UserPayload.createUserWithRolePayload(roleId)
        );

        TestContext.set("createUserResponse", response);
    }

    @Then("user should be created successfully")
    public void user_should_be_created_successfully() {

        Response createUserResponse =
                (Response) TestContext.get("createUserResponse");

        UserValidation.validateCreateUserStatusCode(
                createUserResponse,
                201
        );

        UserValidation.validateUserCreated(
                createUserResponse
        );

        String userId =
                createUserResponse.jsonPath().getString("data.userId");

        TestContext.set("userId", userId);

        System.out.println("Created User ID : " + userId);
    }

    @When("admin fetches created user details")
    public void admin_fetches_created_user_details() {

        String userId =
                TestContext.getString("userId");

        response = UserAPI.getUserById(userId);

        TestContext.set("getUserResponse", response);
    }

    @Then("created user should have assigned role")
    public void created_user_should_have_assigned_role() {

        Response getUserResponse =
                (Response) TestContext.get("getUserResponse");

        String roleId =
                TestContext.getString("roleId");

        UserValidation.validateUserHasAssignedRole(
                getUserResponse,
                roleId
        );
    }
}