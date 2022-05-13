package StepDefs;

import PageObjects.MenuPageObjects;
import PageObjects.SearchPageObjects;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.junit.Assert;

public class SwiggyTest {
    TestContext testContext;
    SearchPageObjects searchPageObjects;
    MenuPageObjects menuPageObjects;


    public SwiggyTest(TestContext context){
        testContext = context;
        searchPageObjects = testContext.getPageObjectManager().getSearchPageObjects();
        menuPageObjects = testContext.getPageObjectManager().getMenuPageObjects();
    }

    @Given("^user access swiggy site$")
    public void user_access_swiggy_site(){
        testContext.getWebDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    @When("^user search the location$")
    public void user_search_the_location(){
        searchPageObjects.searchLocation("Mahadevapura, Bengaluru");
    }

    @And("^user search a dish$")
    public void user_search_a_dish(){
        searchPageObjects.searchDish("Pizza");
        searchPageObjects.accessFirstItem();
    }

    @When("^user access site for the first time then cart is empty$")
    public void isCartEmpty(){
        Assert.assertTrue("Cart is not empty", menuPageObjects.isCartEmpty());
        Assert.assertTrue(menuPageObjects.getNoOfRecommendedItems());
    }

    @Then("^user access an item and add to cart and checkout$")
    public void user_access_an_item_cart_checkout(){
        if(menuPageObjects.getNoOfRecommendedItems()){
            String itemCost= menuPageObjects.getFirstItemCostInListOfItems();
            menuPageObjects.addFirstItem();
            menuPageObjects.addItemAndCheckout();
        }
    }


    @When("^user access an item and add to cart$")
    public void userAccessAnItemAndAddToCart() {
        if(menuPageObjects.getNoOfRecommendedItems()) {
            menuPageObjects.addFirstItem();
            menuPageObjects.addItem();
        }
    }

    @Then("user deleted item in cart")
    public void userDeletedItemInCart() {
        menuPageObjects.minusItemInCart();
    }

    @And("^user search for \"([^\"]*)\"$")
    public void user_search_for(String dish){
        searchPageObjects.searchDish(dish);
        searchPageObjects.accessFirstItem();
    }

    @Then("^order more same item thrice$")
    public void orderMoreSameItemThrice() {
        menuPageObjects.plusItemInCart();
        menuPageObjects.plusItemInCart();
    }
}
