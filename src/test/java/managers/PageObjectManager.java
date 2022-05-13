package managers;

import PageObjects.MenuPageObjects;
import PageObjects.SearchPageObjects;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private SearchPageObjects searchPageObjects;
    private MenuPageObjects menuPageObjects;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public SearchPageObjects getSearchPageObjects(){
        return (searchPageObjects==null) ? searchPageObjects = new SearchPageObjects(driver): searchPageObjects;
    }

    public MenuPageObjects getMenuPageObjects() {
       return (menuPageObjects==null) ? menuPageObjects = new MenuPageObjects(driver): menuPageObjects;
    }
}
