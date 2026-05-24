package payloads;

import models.request.CreateUserRequest;

import java.util.List;
import java.util.Random;

public class UserPayload {

    public static CreateUserRequest createUserWithRolePayload(String roleId) {

        int randomNumber = new Random().nextInt(10000);

        return new CreateUserRequest(
                "Lab User " + randomNumber,
                "labuser" + randomNumber + "@mailinator.com",
                "Test@123",
                "Test@123",
                    null,
                List.of(roleId),
                "0300123" + randomNumber,
                "Karachi",
                null
        );
    }
}