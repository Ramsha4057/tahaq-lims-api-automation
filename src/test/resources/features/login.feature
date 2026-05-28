Feature: Login API Smoke Flow

  @Smoke @Negative
  Scenario: Login fails with invalid credentials

    Given user login with invalid credentials
    Then login response status code should be 401
    And login response should contain error message