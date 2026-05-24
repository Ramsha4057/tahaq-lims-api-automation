Feature: Login API Smoke Flow

  @Smoke @Positive
  Scenario: Successful login with valid credentials

    Given user login with valid credentials
    Then login response status code should be 200
    And login response should contain token


  @Smoke @Negative
  Scenario: Login fails with invalid credentials

    Given user login with invalid credentials
    Then login response status code should be 401
    And login response should contain error message


  @Smoke @Role
  Scenario: Create new lab role successfully

    Given user login with valid credentials
    When admin creates a new lab role
    Then role should be created successfully


  @Smoke @Role
  Scenario: Create new lab role and assign actions successfully

    Given user login with valid credentials

    When admin creates a new lab role
    Then role should be created successfully

    When admin assigns actions to created role
    Then actions should be assigned to role successfully


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