package api;

import base.BaseAPI;
import constants.EndPoints;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class UserAPI {

    public static Response createUser(CreateUserRequest body) {

        Response response = given()
                .spec(BaseAPI.getRequestSpec())
                .body(body)

                .when()
                .post(
                        ConfigReader.getProperty("base.url")
                                + EndPoints.CREATE_USER
                )

                .then()
                .extract()
                .response();

        System.out.println("\n========== CREATE USER RESPONSE ==========");
        System.out.println("Status Code : " + response.getStatusCode());

        System.out.println("\n========== RESPONSE BODY ==========");
        response.getBody().prettyPrint();

        System.out.println("====================================\n");

        return response;
    }

    public static Response getUserById(String userId) {

        Response response = given()

                .spec(BaseAPI.getRequestSpec())

                .queryParam("userId", userId)

                .when()

                .get(
                        ConfigReader.getProperty("base.url")
                                + EndPoints.GET_USER_BY_ID
                )

                .then()

                .extract()

                .response();

        System.out.println("\n========== GET USER RESPONSE ==========");
        System.out.println("Status Code : " + response.getStatusCode());

        System.out.println("\n========== RESPONSE BODY ==========");
        response.getBody().prettyPrint();

        System.out.println("====================================\n");

        return response;
    }
}