package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.TokenManager;

public class BaseAPI {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()

                .addHeader("Content-Type", "application/json")

                .addHeader(
                        "Authorization",
                        TokenManager.getBearerToken()
                )

                .build();
    }
}