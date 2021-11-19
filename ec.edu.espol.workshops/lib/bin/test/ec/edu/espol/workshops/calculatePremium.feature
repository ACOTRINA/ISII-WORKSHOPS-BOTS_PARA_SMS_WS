#language: en

@F1
Feature: Calculate the premium
  
  @E001
  Scenario: Customer is over 80 years old
      Given customer is 85 years old
      When i calculate the premium
      Then show -1

  @E001
  Scenario: Customer is male, not married, and younger than 25 years
      Given customer is male
      And customer is not married
      And customer is 22 years old
      When calculate the premium
      Then show 2000

  @E001
  Scenario: The customer age is between 46 and 64 years old
      Given customer is 51 years old
      When we calculate the premium
      Then show 400