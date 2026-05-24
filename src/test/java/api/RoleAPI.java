package api;

import base.BaseAPI;
import constants.EndPoints;
import io.restassured.response.Response;
import models.request.AssignActionsToRoleRequest;
import models.request.CreateRoleRequest;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class RoleAPI {

    public static Response createRole(CreateRoleRequest body) {

        Response response = given()

                .spec(BaseAPI.getRequestSpec())

                .body(body)

                .when()

                .post(
                        ConfigReader.getProperty("base.url")
                                + EndPoints.CREATE_ROLE
                )

                .then()

                .extract()

                .response();

        System.out.println("\n========== CREATE ROLE RESPONSE ==========");
        System.out.println("Status Code : " + response.getStatusCode());

        System.out.println("\n========== RESPONSE BODY ==========");
        response.getBody().prettyPrint();

        System.out.println("====================================\n");

        return response;
    }

    public static Response assignActionsToRole(
            AssignActionsToRoleRequest body
    ) {

        Response response = given()

                .spec(BaseAPI.getRequestSpec())

                .body(body)

                .when()

                .post(
                        ConfigReader.getProperty("base.url")
                                + EndPoints.ADD_ACTIONS_IN_ROLE
                )

                .then()

                .extract()

                .response();

        System.out.println("\n===== ASSIGN ACTIONS TO ROLE RESPONSE =====");
        System.out.println("Status Code : " + response.getStatusCode());

        System.out.println("\n========== RESPONSE BODY ==========");
        response.getBody().prettyPrint();

        System.out.println("====================================\n");

        return response;
    }
}