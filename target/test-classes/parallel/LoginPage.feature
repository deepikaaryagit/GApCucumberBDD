@SmokeTest
Feature: Login Page feature
 
Background:
Given user enters the url "http://www.gap.com"

@positive 
Scenario: Login Page Title
Then page title should be "Shop Gap for Casual Women's, Men's, Maternity, Baby & Kids Clothes"  
 
Scenario Outline: Login to Application using different set of data
Given user clicks on Sign In Link
And user enters the emailId as "<emailId>"
And user enters the password as "<password>"
And user clicks on Sign In Button
Then user is navigated to signin page
And user is able to see greetings as "<greetings>"

Examples:
	|emailId|password|greetings|
	|ge.crocus1@gmail.com|Gecrocus@22|Hello Ge!|
	|deepika.arya@gmail.com|Anshuarya@22|Hello Deepika!|
	
#@excel
#Scenario Outline: Login to Application using data from excel sheet
#Given user clicks on Sign In Link
#And user enters the emailId and password from "<sheetName>" sheet and row Number <rowNumber>
#And user clicks on Sign In Button
#Then user is navigated to signin page
#And user is able to see greetings
#
#Examples:
#|sheetName|rowNumber|
#|loginDetails|0|
#|loginDetails|1|
#|loginDetails|2|

