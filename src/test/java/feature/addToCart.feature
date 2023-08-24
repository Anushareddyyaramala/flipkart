Feature: feature to search a product from flipcart and add the product to cart

  Scenario: Flipkart search a product and add to cart
  
    Given open browser and enter URL
    When search a product from search bar
    And click on the product
    And validate mouse hower on image is displaying maximised image
    And Add the product to the cart
    Then validate the price on details page with cart price
