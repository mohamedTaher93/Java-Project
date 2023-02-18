Feature: demoblaze Scenarios

  @Login
  Scenario Outline: Login to demoblaze website
    Given I'm login to demoblaze with "<username>" and "<password>"
    Then Verify the "<username>" user logged in successfully

    Examples:
      | username      |  password   |
      | testaccount07 | demo@test!! |

  @CheckCategoriesItems
  Scenario Outline: Check the listed Categories has Items
    Given I'm login to demoblaze with "<username>" and "<password>"
    Then Verify the "<username>" user logged in successfully
    And Verify that "Categories" list group has items

    Examples:
      | username      |  password   |
      | testaccount07 | demo@test!! |

  @AddRandomItemToCart
  Scenario Outline: Add random item to the cart
    Given I'm login to demoblaze with "<username>" and "<password>"
    Then Verify the "<username>" user logged in successfully
    When I add random item to the cart
    Then Verify item added successfully in the cart

    Examples:
      | username      |  password   |
      | testaccount07 | demo@test!! |

  @DeleteItemFromCart
  Scenario Outline: Add random item to the cart
    Given I'm login to demoblaze with "<username>" and "<password>"
    Then Verify the "<username>" user logged in successfully
    When I open the cart page
    Then Verify the cart page has items
    When I delete item from the cart
    Then Verify the item deleted successfully

    Examples:
      | username      |  password   |
      | testaccount07 | demo@test!! |

  @CompleteCheckOut
  Scenario Outline: Complete successful checkout with random item
    Given I'm login to demoblaze with "<username>" and "<password>"
    Then Verify the "<username>" user logged in successfully
    When I add random item to the cart
    Then Verify item added successfully in the cart
    When I open the cart page
    Then Verify the cart page has items
    When I click on place order
    And I enter "<name>" "<country>" "<city>" "<credit card>" "<month>" and "<year>"
    And I click purchase
    Then Verify the item purchased successfully

    Examples:
      | username      |  password   | name| country| city | credit card  | month| year  |
      | testaccount07 | demo@test!! | Taher| Egypt | Cairo| test         |  2   | 2023  |


