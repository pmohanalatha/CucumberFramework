package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.NoSuchElementException;


public class MenuPageObjects {
    WebDriver driver;
    public MenuPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Cart Empty')]")
    public WebElement cartEmpty;

    @FindBy(xpath = "//h2[contains(text(),'Recommended')]/following::div[1]")
    public WebElement recommendedNoOfItems;

    @FindBy(xpath = "//h2[contains(text(),'Recommended')]")
    public WebElement recommendText;

    @FindBy(className = "_1RPOp")
    public List<WebElement> addItemsButtonInCustomizable;

    @FindBy(className = "_1EZLh")
    public WebElement customizablePopup;

    @FindBy(xpath = "//span[contains(@class,'itemPrice')]/span[@class='rupee']")
    public List<WebElement> itemsCostInRecommendedList;

    @FindBy(className ="ueSas")
    public WebElement costInAddItemPopup;

    @FindBy(className = "_38xdN")
    public WebElement addItemButtonInItemPopup;

    @FindBy(xpath = "//button[@class='_1gPB7']")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//span[text()='Secure Checkout']")
    public WebElement secureCheckoutText;

    @FindBy(xpath = "//div[@class='uJZex']/span[1]")
    public WebElement stepsInCustomizeItem;

    @FindBy(xpath = "//div[@class='uJZex']/span[2]")
    public WebElement contnueInCustomizeItem;

    @FindBy(xpath = "//*[@id='menu-content']/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/div[4]")
    public WebElement minusInCart;

    @FindBy(xpath = "//*[@id='menu-content']/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/div[3]")
    public WebElement plusInCart;

    @FindBy(xpath = "//button[text()='REPEAT LAST']")
    public WebElement repeatLastBtn;

    public void sleep(int timeInSeconds){
        try{
            Thread.sleep(timeInSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean getNoOfRecommendedItems(){
        PageFactoryBase.waitUntilElementPresent(driver, recommendText);
        String items = recommendedNoOfItems.getText();
        String[] nItems = items.split(" ");
        return Integer.parseInt(nItems[0])>0;
    }

    public boolean isCartEmpty(){
        return cartEmpty.isDisplayed();
    }

    public void addFirstItem(){
        addItemsButtonInCustomizable.get(0).click();
        PageFactoryBase.waitUntilElementPresent(driver, customizablePopup);
    }

    public String getFirstItemCostInListOfItems(){
        return itemsCostInRecommendedList.get(0).getText();
    }

    public String getItemCostInAddItemsPopup(){
        return costInAddItemPopup.getText();
    }

    public void addItemAndCheckout(){
        boolean flag = false;
        try {
            if (stepsInCustomizeItem.isDisplayed()){
                String steps = stepsInCustomizeItem.getText();
                String[] text= steps.split(" ");
                String[] stepsText= text[1].split("/");
                int nSteps= Integer.parseInt(stepsText[1]);

                for(int i=nSteps;i>0;i--){
                    contnueInCustomizeItem.click();
                    sleep(1000);
                }
                flag = true;
            }

        }catch (Exception e){
            flag = true;
        }

        if(flag==true) {
            addItemButtonInItemPopup.click();
            PageFactoryBase.waitUntilElementPresent(driver,checkoutBtn);
            checkoutBtn.click();
            PageFactoryBase.waitUntilElementPresent(driver,secureCheckoutText);
        }
    }

    public void addItem(){
        boolean flag = false;
        try {
            if (stepsInCustomizeItem.isDisplayed()){
                String steps = stepsInCustomizeItem.getText();
                String[] text= steps.split(" ");
                String[] stepsText= text[1].split("/");
                int nSteps= Integer.parseInt(stepsText[1]);

                for(int i=nSteps;i>0;i--){
                    contnueInCustomizeItem.click();
                    sleep(1000);
                }
                flag = true;
            }

        }catch (Exception e){
            flag = true;
        }

        if(flag==true) {
            addItemButtonInItemPopup.click();
            PageFactoryBase.waitUntilElementPresent(driver,checkoutBtn);
        }
    }

    public void minusItemInCart(){
        minusInCart.click();
        PageFactoryBase.waitUntilElementPresent(driver,cartEmpty);
    }

    public void plusItemInCart(){
        plusInCart.click();
        try{
            if(repeatLastBtn.isDisplayed()){
                repeatLastBtn.click();
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

    }


}
