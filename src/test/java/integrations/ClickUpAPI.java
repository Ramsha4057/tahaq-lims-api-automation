package integrations;

import io.restassured.http.ContentType;
import utils.ConfigReader;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

public class ClickUpAPI {

    public static void createFailureTask(
            String scenarioName,
            String errorMessage
    ) {

        String token =
                ConfigReader.getClickUpProperty("clickup.token");

        String listId =
                ConfigReader.getClickUpProperty("clickup.list.id");

        String timestamp =
                LocalDateTime.now().toString();

        String requestBody = """
                {
                  "name": "FAILED API TEST - %s",
                  "description": "Scenario Name: %s\\n\\nError: %s\\n\\nTimestamp: %s"
                }
                """.formatted(
                scenarioName,
                scenarioName,
                errorMessage,
                timestamp
        );

        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post(
                        "https://api.clickup.com/api/v2/list/"
                                + listId
                                + "/task"
                )

                .then()
                .statusCode(200);

        System.out.println(
                "ClickUp task created for failed scenario: "
                        + scenarioName
        );
    }
}