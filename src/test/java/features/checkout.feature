Feature: Place order for vegetables 

@PlaceOrder
Scenario: Search experince for product search in both home and offers page 

Given User is on GreenCart Landing page 
When User searched with shortname "Tom" and extracted actual name of the product 
And Add "3" items of the seleted product to cart
Then User proceeds to CheckOut and validate the "Tom" items in checkout page
And Verify user has ability to enter promo code and place order


