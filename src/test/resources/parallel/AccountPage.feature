Feature: Account Page feature

Background:
Given user has already logged into the application
|emailId|password|
|deepika.arya@gmail.com|Anshuarya@22|

@positive
Scenario: Account Page Title
Given user is on Accounts page
Then page title should be "My Account | Gap" 

@regression 
Scenario:
Given user is on Accounts page
Then user can see the accounts sections 
|ACCOUNT DETAILS|
|ORDERS & RETURNS|
|WALLET|
And account section count should be 3

	