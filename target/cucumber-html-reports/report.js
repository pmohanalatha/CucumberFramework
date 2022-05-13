$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/SwiggyFeatures.feature");
formatter.feature({
  "name": "To Test Swiggy website",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search for an item, add to cart and checkout",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user access swiggy site",
  "keyword": "Given "
});
formatter.match({
  "location": "SwiggyTest.user_access_swiggy_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search the location",
  "keyword": "When "
});
formatter.match({
  "location": "SwiggyTest.user_search_the_location()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search a dish",
  "keyword": "And "
});
formatter.match({
  "location": "SwiggyTest.user_search_a_dish()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user access site for the first time then cart is empty",
  "keyword": "When "
});
formatter.match({
  "location": "SwiggyTest.isCartEmpty()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user access an item and add to cart and checkout",
  "keyword": "Then "
});
formatter.match({
  "location": "SwiggyTest.user_access_an_item_cart_checkout()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});