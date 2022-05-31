package tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.n11Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class Q2_n11 {

    @Test
    public void test01() throws IOException {
        n11Page n11Page = new n11Page();

        //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
        //seçilir.
        Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(n11Page.dahaSonraButton));
        n11Page.dahaSonraButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(n11Page.magazalarMenu).perform();


        wait.until(ExpectedConditions.visibilityOf(n11Page.magazalariGorElement));
        actions.click(n11Page.magazalariGorElement).perform();


        //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
        //txt dosyasına yazdırılır.

        n11Page.tumMagazalarElement.click();

        String dosyaYolu= "src/resources/n11.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sutun = 10;
        int satir = n11Page.aHarfIcerenTumMagazalar.size()/sutun;
        int index=0;


        for (int i=0; i<satir;i++){
            workbook.getSheet("Sayfa1").createRow(i);
            for (int j=0;j<sutun;j++){
                String eklenecekText = n11Page.aHarfIcerenTumMagazalar.get(index).getText();
                workbook.getSheet("Sayfa1").getRow(i).createCell(j).setCellValue(eklenecekText);
                index++;
                if (index==n11Page.aHarfIcerenTumMagazalar.size()-1) break;
            }
            if (index==n11Page.aHarfIcerenTumMagazalar.size()-1) break;
        }


        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();


    }
}
