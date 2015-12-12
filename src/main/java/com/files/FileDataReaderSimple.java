package main.java.com.files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by rgonugunta on 12/11/15.
 */
public class FileDataReaderSimple {

    private static Properties getProperties() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            File file = new File("testdata/url.properties");
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Exception - " + e.getMessage());
        }
        return properties;
    }

    private static Properties props = getProperties();

    public String getProp(String key) {
        return props.getProperty(key);
    }

}
