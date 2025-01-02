#Feature: Validate product quantity availability
#
#  As a user
#  I want to ensure that I am informed if a requested product quantity is unavailable
#  So that I can adjust the quantity and complete my purchase successfully
#
#  Scenario: Add unavailable quantity of "Push It Messenger Bag" to cart
#    Given I am on the homepage
#    When I search for "Push It Messenger Bag"
#    And I select the product
#    And I set the quantity to 1
#    And I click "Add to Cart"
#    Then the message "You added Push It Messenger Bag Tank to your" should be displayed
#    And the cart should be updated with the product

#Feature: Button Appearance and Functionality
#  As a user,
#  I want buttons on the website to be visibly interactive
#  So that I can understand they are clickable and perform actions correctly
#
#  Scenario: Button's hover effect works correctly
#    Given I am on the Magento homepage
#    And I have a product in the cart
#    When I navigate to the shopping cart page
#    And I click on the Proceed to Checkout button
#    Then the button should change color or size as defined in the style guide
#    And the cursor should change to indicate it is clickable
#
#  Scenario: Add to Cart button works as expected
#    Given I am on a product page
#    When I click the "Add to Cart" button
#    Then the item should be added to my shopping cart
#    And the cart icon should update to reflect the new item count

