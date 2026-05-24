package models.request;

import java.util.List;

public class CreateUserRequest {

    private String name;
    private String email;
    private String password;
    private String confirmedPassword;
    private String userType;
    private List<String> roleIds;
    private String contactNo;
    private String address;
    private String departmentId;

    public CreateUserRequest(
            String name,
            String email,
            String password,
            String confirmedPassword,
            String userType,
            List<String> roleIds,
            String contactNo,
            String address,
            String departmentId
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.userType = userType;
        this.roleIds = roleIds;
        this.contactNo = contactNo;
        this.address = address;
        this.departmentId = departmentId;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getConfirmedPassword() { return confirmedPassword; }
    public String getUserType() { return userType; }
    public List<String> getRoleIds() { return roleIds; }
    public String getContactNo() { return contactNo; }
    public String getAddress() { return address; }
    public String getDepartmentId() { return departmentId; }
}
