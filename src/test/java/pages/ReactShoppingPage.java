package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ReactShoppingPage {
    public ReactShoppingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@tabindex='1']")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//p[@class='sc-124al1g-6 ljgnQL']")
    public List<WebElement> allPrices;

    @FindBy(xpath = "//button[@class='sc-1h98xa9-0 gFkyvN']")
    public WebElement cartButton;

    @FindBy(xpath = "//*[text()='Add to cart']")
    public List<WebElement> addToCartButton;

    @FindBy(xpath = "//p[@class='sc-1h98xa9-9 jzywDV']")
    public WebElement subTotalElement;

    @FindBy(xpath = "//*[text()='Checkout']")
    public WebElement checkOutButton;

    @FindBy(xpath = "//button[@class='sc-1h98xa9-0 gFkyvN']")
    public WebElement cartCloseButton;


}
