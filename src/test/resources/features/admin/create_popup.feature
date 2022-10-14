Feature: This feature will cover possible scenarios of checking password input in create popup of admin page,
  especially on teachers, students, parent section.

  Background:
    Given Fill heghine9696@gmail.com and 2kB$8tU#1aO( fields
    And Click on 'login' button

  @TC1.8.3 @TC1.9.11 @TC1.10.12 @Regression @Smoke
  Scenario Outline: Check functionality of 'Generate password' button in create popup
    When Select <section> section
    And Click on 'create' button and open popup
    And Click on 'Generate password' button
    Then 'Password' field is filled with autogenerated password
    And Check the structure of generated password

    Examples:
      | section  |
      | teachers |
      | students |
      | parents  |


  @TC1.8.4 @TC1.9.12 @TC1.10.13 @Regression @Smoke
  Scenario Outline: Check functionality to regenerate password
    When Select <section> section
    And Click on 'create' button and open popup
    And Click on 'Generate password' button
    And Get value from password input field
    And Click on 'Generate password' button
    Then Check the generated password has been changed
    And Check 'Generate password' button is active

    Examples:
      | section  |
      | teachers |
      | students |
      | parents  |

  @TC1.8.10 @TC1.9.13 @TC1.10.14 @Regression @Smoke
  Scenario Outline: Check possibility to write in Password field/create popup
    When Select <section> section
    And Click on 'create' button and open popup
    Then Check the user is not able to input any data in the password field

    Examples:
      | section  |
      | teachers |
      | students |
      | parents  |


  @TC1.8.8 @TC1.9.14 @TC1.10.15 @Regression @Smoke
  Scenario Outline: Check structure of autogenerated password
    When Select <section> section
    And Click on 'create' button and open popup
    And Click on 'Generate password' button
    Then 'Password' field is filled with autogenerated password
    And Check the structure of generated password

    Examples:
      | section  |
      | teachers |
      | students |
      | parents  |


  @TC1.8.6 @TC1.10.9 @TC1.9.10 @Regression @Smoke
  Scenario Outline: Check structure of email
    When Select <section> section
    And Click on 'create' button and open popup
    And Fill invalid email
    And Click on 'Save' button
    Then Check invalid email error message

    Examples:
      | section  |
      | teachers |
      | students |
      | parents  |