package payloads;

import models.request.AssignActionsToRoleRequest;
import models.request.CreateRoleRequest;

import java.util.List;
import java.util.Random;

public class RolePayload {

    public static CreateRoleRequest createLabRolePayload() {

        int randomNumber =
                new Random().nextInt(10000);

        return new CreateRoleRequest(

                "LabRole_" + randomNumber,

                "Dynamic lab role created by automation",

                "LAB_ROLE_" + randomNumber
        );
    }

    public static AssignActionsToRoleRequest assignActionsToRolePayload(String roleId) {

        return new AssignActionsToRoleRequest(

                roleId,

                List.of(

                        "/tahaq-auth/IUserManagementFeature/GetUsers",

                        "/tahaq-auth/IUserManagementFeature/GetUserById"

                )
        );
    }
}