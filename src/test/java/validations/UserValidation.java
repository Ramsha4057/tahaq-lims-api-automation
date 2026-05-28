package validations;

import io.restassured.response.Response;
import org.testng.Assert;

public class UserValidation {

    public static void validateCreateUserStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public static void validateUserCreated(Response response) {
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
        Assert.assertNotNull(response.jsonPath().getString("data"));
    }

    public static void validateUserHasAssignedRole(Response response, String expectedRoleId) {

        Assert.assertEquals(response.getStatusCode(), 200);

        String responseBody = response.getBody().asString();

        Assert.assertTrue(
            responseBody.contains(expectedRoleId),
            "Created roleId is not assigned to user"
        );
    }



    public static void validateUserDeleted(Response response) {
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.jsonPath().getString("message"), "Success");
}
}