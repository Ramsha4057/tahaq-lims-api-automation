package validations;

import io.restassured.response.Response;
import org.testng.Assert;

public class RoleValidation {

    public static void validateCreateRoleStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public static void validateRoleCreated(Response response) {
        Assert.assertNotNull(response.jsonPath().getString("data"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
    }
}