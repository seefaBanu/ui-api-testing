#Feature: Login to HRM Application
#
#  Background:
#    Given User is on HRMLogin page "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/"
#
#  @ValidCredentials
#  Scenario: Login with valid credentials
#
#    When User enters username as "testuser123test@gmail.com" and password as "Test@123"
#    Then User should be able to login sucessfully and new page open
#
#  @InvalidCredentials
#  Scenario Outline: Login with invalid credentials
#
#    When User enters username as "<username>" and password as "<password>"
#    Then User should be able to see error message "<errorMessage>"
#
#    Examples:
#      | username   | password     | errorMessage                       |
#      | testuser123test@gmail.com | admin12$$   | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.|
#
