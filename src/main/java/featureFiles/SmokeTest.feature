#Author: raghavhsp@gmail.com
#Since: 17-MAR-2025
#Keywords Summary : Created For Automation Of Sample Features
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



Feature: Testing Of Features in https://practice.expandtesting.com/

Background: 
Given Browser Started and Window Maximized

Scenario: Validate that user is able to register using register page
Given User is on Home Page
When User navigate to Regiter Page
And Enter Details in regiter page
Then Registration success message should appear

Scenario: Validate that user is unable to register using register page with Wrong Credentails
Given User is on Home Page
When User navigate to Regiter Page
And Enter Invalid Details in regiter page
Then Registration success message should not appear



