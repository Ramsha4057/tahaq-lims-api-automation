package api;

import base.BaseAPI;
import constants.EndPoints;
import io.restassured.response.Response;
import models.request.LoginRequest;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class AuthAPI {

    public static Response login(LoginRequest body) {

        Response response = given()

                .spec(BaseAPI.getRequestSpec())

                .body(body)

                .when()

                .post(
                        ConfigReader.getProperty("base.url")
                                + EndPoints.LOGIN
                )

                .then()

                .extract()

                .response();

        System.out.println("\n========== LOGIN RESPONSE ==========");
        System.out.println("Status Code : " + response.getStatusCode());

        System.out.println("\n========== RESPONSE BODY ==========");
        response.getBody().prettyPrint();

        System.out.println("====================================\n");

        return response;
    }
}