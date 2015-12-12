package test.java.com.files;

import org.openqa.selenium.firefox.FirefoxDriver;

import main.java.com.files.FileDataReaderSimple;

/**
 * Created by rgonugunta on 12/11/15.
 */
public class TestFileDataReaderSimple {


    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        FileDataReaderSimple fileReader = new FileDataReaderSimple();
        try {
            String url = fileReader.getProp("gap.url");
            driver.get(url);
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
