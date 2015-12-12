package test.java.com.files;

import org.openqa.selenium.firefox.FirefoxDriver;

import main.java.com.files.ExcelDataReaderSimple;

/**
 * Created by rgonugunta on 12/11/15.
 */
public class TestExcelDataReaderSimple {


    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        ExcelDataReaderSimple excelReader = new ExcelDataReaderSimple();
        try {
            String url = excelReader.getProp("amazon.url");
            driver.get(url);
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
