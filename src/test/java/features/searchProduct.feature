Feature: Search and place order for vegetables 

@offersPage
Scenario: Search experince for product search in both home and offers page 

Given User is on GreenCart Landing page 
When User searched with shortname "Tom" and extracted actual name of the product 
Then User searched for "Tom" shortname in offers page
And validate product name is same in both landing page and offer page

@offersPage
Scenario: Search experince for product search in both home and offers page 

Given User is on GreenCart Landing page 
When User searched with shortname "Beet" and extracted actual name of the product 
Then User searched for "Beets" shortname in offers page
And validate product name is same in both landing page and offer page

#Scenario Outline: Search experince for product search in both home and offers page 
#Given User is on GreenCart Landing page 
#When User searched with shortname <Name> and extracted actual name of the product 
#Then User searched for <Name> shortname in offers page
#And validate product name is same in both landing page and offer page

#Examples:
#| Name |
#| Tom  |
#| Beet |