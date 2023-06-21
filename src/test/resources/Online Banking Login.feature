@Smoke @Regression
Feature: Login function test
description: 

@Positive @TC_OB-4
Scenario: Check login with valid credentials
Given Open browser and  go to application 
When put valid user name
When put valid password value
When click login button
Then logout should there

@Negative @TC_LP-19
Scenario: Check login with invalid credentials
Given Open browser and  go to application 
When put invalid user name
When put invalid password value
When click login button
Then alert msg showed Invalid username or password

@Negative @TC_LP-20
Scenario: Check login with null credentials
Given Open browser and  go to application 
When put null user
When put null password
When click login
Then alert msg showed Invalid username or password

