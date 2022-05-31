package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoGuruPage {
    public DemoGuruPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()=' BANK ']")
    public WebElement bankElement;

    @FindBy(xpath = "//*[text()=' SALES ']")
    public WebElement salesElement;

    @FindBy(xpath = "//*[text()=' 5000 ']")
    public WebElement fiveThousandElement;

    @FindBy(xpath = "//a[text()=' 5000']")
    public WebElement fiveThousandElement2;

    @FindBy(id = "shoppingCart1")
    public WebElement debitSideAccount;

    @FindBy(xpath = "(//div[@id='shoppingCart4'])[1]")
    public WebElement debitSideAmount;

    @FindBy(xpath = "(//div[@id='shoppingCart4'])[2]")
    public WebElement creditSideAmount;

    @FindBy(id="shoppingCart3")
    public WebElement creditSideAccount;

    @FindBy(xpath = "//*[text()='Perfect!']")
    public WebElement perfectElement;
}
