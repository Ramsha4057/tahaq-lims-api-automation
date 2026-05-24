package validations;

import io.restassured.response.Response;
import org.testng.Assert;

public class LoginValidation {

    public static void validateStatusCode(Response response, int expectedStatusCode) {

        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public static void validateToken(Response response) {

        Assert.assertNotNull(
                response.jsonPath().getString("data.token")
        );
    }

    public static void validateErrorMessage(Response response) {

        Assert.assertNotNull(response.jsonPath().getString("message"));
    }
}