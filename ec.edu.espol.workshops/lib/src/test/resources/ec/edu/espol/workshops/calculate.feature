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
@tag
Feature: Calculate the insurance prime for a customer 
  I want to use this template for my feature file

  @tag1
  Scenario: Customer is over 80 years
    Given customer is over 80 years
    When calculate the premium
    Then show -1

  @tag2
  Scenario Outline: 
    Given customer is over <age>
    When I calculate the premium 
    Then I should be shown <answer>

    Examples: 
      |  age   | answer |
      |   70   |    0   |
      |   81   |   -1   |


@tag
Feature: Calculate the insurance prime for a customer 
  I want to use this template for my feature file

  @tag1
  Scenario: Customer is 45 years or older, but younger than 65
    Given customer is 45 years or over 45 years.
    And customer is younger than 65 years
    When calculate the premium
    Then show 600

  @tag2
  Scenario Outline: 
    Given customer is over <age>
    And customer is younger than <age>
    When I calculate the premium 
    Then I should be shown <answer>

    Examples: 
      |   age  | answer |
      |   55   |  600   |
      |   25   |  400   |
			|   70   |  500   |
			
@tag
Feature: Calculate the insurance prime for a customer 
  I want to use this template for my feature file

  @tag1
  Scenario: Customer is male, not married, and younger than 25 years
    Given customer is male
    And customer is not married
    And customer is younger than 25 years
    When calculate the premium
    Then show 2000

  @tag2
  Scenario Outline: 
    Given customer is <gender>
    And customer is <maritalStatus>
    And customer is younger than <age>
    When I calculate the premium 
    Then I should be shown <answer>

    Examples: 
      |  age  | gender  | maritalStatus | answer |  
      |   50  |  female |   married     |  600   |
      |   24  |  male   |  not married  |  600   |
			|   70  |  500    |   married     |  600   |
