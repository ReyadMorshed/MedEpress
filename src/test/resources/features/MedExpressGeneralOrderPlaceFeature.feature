@Regression
Feature: Customer general order place feature
  As a customer I want to login and place a general order to the Medexpress customer website

  @Regression
  Scenario: User will be able to login with valid credentials
    Given Navigate to MedExpress website
    And Validate the landing page
    Then User is in the landing page, Click on the login link
    And Validate the login page
    And Give the email "reyad@alagzoo.com" and password "Reyad@123"
    Then Click on the login button
    And validate the homepage
    Then Search a product "AROCAFE"
    And Click on the search reasult
    Then validate the product details page
    Then click on the add to cart button
    Then Go to the cart page
    And check the terms & condition checkbox
    And click on the checkout button
    And click on shipping address button 	 
    Then select pickup at store as shipping method
    And click on confirm button
    Then validate the order confirmation