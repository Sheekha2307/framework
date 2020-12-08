@FB

Feature: check facebook login functionality
We are checking login functionality

Scenario Outline: Successful Login with Valid Credentials
	 Given User Navigate to LogIn Page
   When User enters "<UserName>" and "<Password>" 
   Then homepage is displayed Login Successfully
   
Examples:
|Username|Password|
|9970072899|Summer@2020|
|sheekha|test123|
     	

   
   