package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SearchPageObjects {

    WebDriver driver;

    @FindBy(id = "location")
    public WebElement deliveryLocationTextbox;

    @FindBy(xpath = "//div[@class='_3lmRa']/span[2]")
    public List<WebElement> searchOptions;

    @FindBy(xpath = "//a[@href='/search'][@class='_1T-E4']")
    public WebElement searchLink;

    @FindBy(xpath = "//input[@placeholder='Search for restaurants or dishes'] | //input[@placeholder='Search for restaurants and food']")
    public WebElement searchResDishField;

    @FindBy(className = "_2yTju")
    public WebElement searchResults;

    @FindBy(xpath = "//div[@class='_2yTju']/div/div/a")
    public List<WebElement> searchResultItems;

    public SearchPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchLocation(String searchText){
        deliveryLocationTextbox.sendKeys(searchText);
        sleep(4000);
        searchOptions.get(0).click();
        sleep(4000);
    }

    public void searchDish(String dish){
        searchLink.click();
        sleep(4000);
        PageFactoryBase.waitUntilElementPresent(driver, searchResDishField);
        searchResDishField.sendKeys(dish);
        sleep(4000);
        searchResDishField.sendKeys(Keys.ENTER);
        sleep(4000);
    }

    public void accessFirstItem(){
        if(searchResultItems.size()>0){
            searchResultItems.get(0).click();
            sleep(4000);
        }
    }

    public void sleep(int timeInSeconds){
        try{
            Thread.sleep(timeInSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
