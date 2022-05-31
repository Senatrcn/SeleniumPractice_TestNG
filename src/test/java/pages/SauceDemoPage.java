package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {
    public SauceDemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameElement;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "(//div[@class='inventory_item_name'])[1]")
    public WebElement birinciUrunElement;

    @FindBy(xpath = "//*[text()='Add to cart']")
    public WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartLinkElement;

    @FindBy(className = "inventory_item_name")
    public WebElement sepettekiUrunElement;
}
