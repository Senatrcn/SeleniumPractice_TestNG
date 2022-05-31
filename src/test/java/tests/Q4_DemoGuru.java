package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoGuruPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q4_DemoGuru {

    @Test
    public void test01() {

        DemoGuruPage demoGuruPage = new DemoGuruPage();

       // http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(ConfigReader.getProperty("demoGuruUrl"));

        //DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(demoGuruPage.bankElement, demoGuruPage.debitSideAccount).perform();

        //CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.salesElement,demoGuruPage.creditSideAccount).perform();

        //DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.fiveThousandElement,demoGuruPage.debitSideAmount).perform();

        //CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.fiveThousandElement2,demoGuruPage.creditSideAmount).perform();

        //Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(demoGuruPage.perfectElement.isDisplayed());
    }
}
