package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class n11Page {
    public n11Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[text()='Daha Sonra'])[1]")
    public WebElement dahaSonraButton;

    @FindBy(xpath = "//span[@title='Mağazalar']")
    public WebElement magazalarMenu;

    @FindBy(xpath = "//a[text()='Mağazaları Gör']" )
    public WebElement magazalariGorElement;

    @FindBy(xpath = "//h3[text()='Tüm Mağazalar']")
    public WebElement tumMagazalarElement;

    @FindBy(xpath = "//div[@class='tabPanel allSellers']//li")
    public List<WebElement> aHarfIcerenTumMagazalar;

}
