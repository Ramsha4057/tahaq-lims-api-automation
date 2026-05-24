package models.request;

public class CreateRoleRequest {

    private String roleName;
    private String description;
    private String tag;

    public CreateRoleRequest(String roleName, String description, String tag) {
        this.roleName = roleName;
        this.description = description;
        this.tag = tag;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }
}