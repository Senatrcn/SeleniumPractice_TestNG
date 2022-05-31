package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()=' Signup / Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='New User Signup!']")
    public WebElement newUserSignupElement;

    @FindBy(name ="name")
    public WebElement nameButton;

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement enterAccountInformationElement;

    @FindBy(name ="title")
    public WebElement mrsTitleRadioButton;

}
