package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q1_SauceDemo {

    @Test
    public void test01() {
        SauceDemoPage sauceDemoPage = new SauceDemoPage();
        //1. "https://www.saucedemo.com" Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));

        //2. Username kutusuna "standard_user" yazdirin
        sauceDemoPage.usernameElement.sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        sauceDemoPage.passwordElement.sendKeys("secret_sauce");

        //4. Login tusuna basin
        sauceDemoPage.loginButton.click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String birinciUrunIsmi = sauceDemoPage.birinciUrunElement.getText();
        sauceDemoPage.birinciUrunElement.click();

        //6. Add to Cart butonuna basin
        sauceDemoPage.addToCartButton.click();

        //7. Alisveris sepetine tiklayin
        sauceDemoPage.cartLinkElement.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Assert.assertTrue(sauceDemoPage.sepettekiUrunElement.getText().contains(birinciUrunIsmi));

        //9. Sayfayi kapatin
        Driver.closeDriver();
    }
}
