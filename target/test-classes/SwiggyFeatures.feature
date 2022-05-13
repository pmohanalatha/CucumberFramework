Feature: To Test Swiggy website
  Scenario: Search for an item, add to cart and checkout
    Given user access swiggy site
    When user search the location
    And user search a dish
    When user access site for the first time then cart is empty
    Then user access an item and add to cart and checkout

#  Scenario: Search for an item, add to cart and remove from cart
#    Given user access swiggy site
#    When user search the location
#    And user search a dish
#    When user access an item and add to cart
#    Then user deleted item in cart
#
#  Scenario Outline: Search for an item, add to cart and remove from cart
#    Given user access swiggy site
#    When user search the location
#    And user search for "<dish_name>"
#    When user access an item and add to cart
#    Examples:
#      | dish_name     |
#      | pizza         |
#      | Italian pasta |
#
#    Scenario: Search for an item, add to cart and order more same item
#    Given user access swiggy site
#    When user search the location
#    And user search a dish
#    When user access an item and add to cart
#    Then order more same item thrice
