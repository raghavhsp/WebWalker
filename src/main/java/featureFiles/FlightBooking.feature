#Author: your.email@your.domain.com
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


Feature: Flight Booking Service Test

@Smoke
Scenario Template: Validate that user is able to login to application
Given User is on login page
When User enter creds as "<UserName>" and "<Password>"
Then User should be able to login
Examples:
     |UserName|Password|
     |raghavhsp@gmail.com|Gagu255245@|
     |raghavhsp1@gmail.com|Gagu255245@|
   	 |raghavhsp2@gmail.com|Gagu255245@|
     |raghavhsp3@gmail.com|Gagu255245@|
     |raghavhsp4@gmail.com|Gagu255245@|
     |raghavhsp5@gmail.com|Gagu255245@|
     |raghavhsp6@gmail.com|Gagu255245@|
     
 
 Scenario: Regiter User
 Given User is on regiter user page
 When User enter data as below and create user
 |Raghav|
 |30|
 |Single|
 |raghavhsp@gmail.com|
 Then Registration successfull should appear on screen
 
 @Regression @Smoke
 Scenario: Validate Flight Against Pilot
 Given : User has list of filghts and its pilots for today
 When : User match fligh to pilot details as below
 |FA001|RAM|
 |FA002|SHAM|
 |FA003|SOHAN|
 |FA004|MOHAN|
 |FA005|RAJA|
 
 
 