
@Smoke
Feature: Customer upload prescription feature
  As a customer I want to login and upload prescription to the Medexpress customer website

  @Smoke
  Scenario: User will be able to login with valid credentials
    Given Navigate to MedExpress website
    And Validate the landing page
    Then User is in the landing page, Click on the login link
    And Validate the login page
    And Give the email "reyad@alagzoo.com" and password "Reyad@123"
    Then Click on the login button
    And validate the homepage
    Then click on upload prescription button
    And write the doctor name
    And upload the prescription
    Then click on checkout button
    And click on shipping address button
    And click on confirm button
    Then validate the order confirmation

  
