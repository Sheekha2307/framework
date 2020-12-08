
Feature: End to end test

Scenario: User is able to login into Amazon application and buy product

Given user is on Amazon Home Page
When he search for “masks”
And choose to buy the first item
And moves to checkout from mini cart
And enter personal details on checkout page
And select same delivery address
#And select payment method as “check” payment
And place the order