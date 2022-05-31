package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactShoppingPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;

public class Q3_ReactShopping {

    @Test
    public void test01() {
        ReactShoppingPage reactShoppingPage = new ReactShoppingPage();

        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("reactShoppingUrl"));

        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        reactShoppingPage.allProducts.stream().forEach(t-> System.out.println((reactShoppingPage.allProducts.indexOf(t)+1)+". Urun : "+t.getText()));

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> productNames = new ArrayList<>();
        reactShoppingPage.allProducts.stream().forEach(t ->productNames.add(t.getText()));

        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        Set<WebElement> randomProducts = new HashSet<>();
        Random rand = new Random();
        int randomIndex;
        double sumOfRandomPrices=0;

        while (randomProducts.size()<5){

            randomIndex=rand.nextInt(reactShoppingPage.allProducts.size());
            System.out.println(randomIndex);


            randomProducts.add(reactShoppingPage.allProducts.get(randomIndex));
            sumOfRandomPrices += Double.parseDouble(reactShoppingPage.allPrices.get(randomIndex).getText().replace("$","")) ;
            reactShoppingPage.addToCartButton.get(randomIndex).click();
            reactShoppingPage.cartCloseButton.click();
        }

        reactShoppingPage.cartButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(reactShoppingPage.subTotalElement));
        Double actualTotal = Double.parseDouble(reactShoppingPage.subTotalElement.getText().replace("$","").trim());

        sumOfRandomPrices = Double.parseDouble(new DecimalFormat("##.##").format(sumOfRandomPrices));


        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        Assert.assertEquals(actualTotal , sumOfRandomPrices);

        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        System.out.println("Test passed");

        // 7.Checkout'a tıklayın
        reactShoppingPage.checkOutButton.click();
        Driver.getDriver().switchTo().alert().accept();


    }
}
