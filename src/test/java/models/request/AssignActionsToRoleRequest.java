package models.request;

import java.util.List;

public class AssignActionsToRoleRequest {

    private String roleId;
    private List<String> actions;

    public AssignActionsToRoleRequest(String roleId, List<String> actions) {
        this.roleId = roleId;
        this.actions = actions;
    }

    public String getRoleId() {
        return roleId;
    }

    public List<String> getActions() {
        return actions;
    }
}