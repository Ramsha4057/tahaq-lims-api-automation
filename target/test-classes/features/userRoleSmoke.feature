Feature: User Role Management Smoke Flow

  @Smoke @UserRole
  Scenario: Create role with actions and assign role to new user

    Given user login with valid credentials

    When admin creates a new lab role
    Then role should be created successfully

    When admin assigns actions to created role
    Then actions should be assigned to role successfully

    When admin creates a new user with created role
    Then user should be created successfully

    When admin fetches created user details
    Then created user should have assigned role

    When admin deletes created user
    Then user should be deleted successfully