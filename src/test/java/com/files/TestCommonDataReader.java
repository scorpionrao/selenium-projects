package test.java.com.files;

import org.openqa.selenium.firefox.FirefoxDriver;

import main.java.com.files.DataReaderInterface;
import main.java.com.files.FileDataReaderWithInterface;

/**
 * Created by rgonugunta on 12/12/15.
 */
public class TestCommonDataReader {

    static DataReaderInterface commonReader = new FileDataReaderWithInterface();
    //static DataReaderInterface commonReader = new ExcelDataReaderWithInterface();

    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        try {
            String url = commonReader.getProp("gap.url");
            driver.get(url);
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
