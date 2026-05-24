package stepdefinitions;

import api.RoleAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import payloads.RolePayload;
import testcontext.TestContext;
import validations.RoleValidation;

public class RoleSteps {

    Response response;

    @When("admin creates a new lab role")
    public void admin_creates_a_new_lab_role() {

        response = RoleAPI.createRole(
                RolePayload.createLabRolePayload()
        );

        TestContext.set("createRoleResponse", response);
    }

    @Then("role should be created successfully")
    public void role_should_be_created_successfully() {

        Response createRoleResponse =
                (Response) TestContext.get("createRoleResponse");

        // STATUS CODE VALIDATION
        RoleValidation.validateCreateRoleStatusCode(
                createRoleResponse,
                201
        );

        // RESPONSE VALIDATION
        RoleValidation.validateRoleCreated(createRoleResponse);

        // STORE ROLE ID
        String roleId =
                createRoleResponse.jsonPath().getString("data");

        TestContext.set("roleId", roleId);

        System.out.println("Created Role ID : " + roleId);
    }

    @When("admin assigns actions to created role")
    public void admin_assigns_actions_to_created_role() {

        String roleId =
                TestContext.getString("roleId");

        response = RoleAPI.assignActionsToRole(

                RolePayload.assignActionsToRolePayload(roleId)
        );

        TestContext.set(
                "assignActionsResponse",
                response
        );
    }

    @Then("actions should be assigned to role successfully")
    public void actions_should_be_assigned_to_role_successfully() {

        Response assignActionsResponse =

                (Response) TestContext.get(
                        "assignActionsResponse"
                );

        RoleValidation.validateCreateRoleStatusCode(
                assignActionsResponse,
                201
        );

        RoleValidation.validateRoleCreated(
                assignActionsResponse
        );
    }
}