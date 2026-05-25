Feature: Login API Smoke Flow

  @Smoke @Negative
  Scenario: Login fails with invalid credentials

    Given user login with invalid credentials
    Then login response status code should be 401
    And login response should contain error message


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