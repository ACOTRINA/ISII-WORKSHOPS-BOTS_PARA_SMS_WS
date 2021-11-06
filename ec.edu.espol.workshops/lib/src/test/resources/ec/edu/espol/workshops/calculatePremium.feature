#Author: oyguzman@espol.edu.ec
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@F1
Feature: Calculate the insurance prime for an old customer
  I want to use this template for my feature file
  
  @E001
  Scenario: Customer is over 80 years old
    Given customer is 85 years old
    When i calculate the premium
    Then show -1

  @E002
  Scenario: Customer is male, not married, and younger than 25 years
    Given customer is male
    And customer is not married
    And customer is 22 years old
    When calculate the premium
    Then show 2000

  @E003 
  Scenario: The customer age is between 46 and 64 years old
    Given customer is 51 years old
    When we calculate the premium
    Then show 400


