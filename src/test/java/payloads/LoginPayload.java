package payloads;

import models.request.LoginRequest;

public class LoginPayload {

    public static LoginRequest validLoginPayload() {

        return new LoginRequest(
                "quality@inspection.com",
                "Quality!23"
        );
    }

    public static LoginRequest invalidLoginPayload() {

        return new LoginRequest(
                "quality@inspection.com",
                "wrongpassword"
        );
    }
}