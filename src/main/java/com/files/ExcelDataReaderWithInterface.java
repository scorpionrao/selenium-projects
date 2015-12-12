package main.java.com.files;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by rgonugunta on 12/11/15.
 */
public class ExcelDataReaderWithInterface implements DataReaderInterface {

    public static Properties getProperties() {
        Properties properties = new Properties();
        HSSFCell cell1 = null;
        HSSFCell cell2 = null;
        try {
            FileInputStream input = new FileInputStream("testdata/url.xls");
            POIFSFileSystem fileSystem = new POIFSFileSystem(input);
            HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
            HSSFSheet sheet = workBook.getSheetAt(0);
            Iterator rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                HSSFRow row = (HSSFRow) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    cell1 = (HSSFCell) cellIterator.next();
                    String key = cell1.getRichStringCellValue().toString();
                    if (!cellIterator.hasNext()) {
                        properties.put(key, "");
                    } else {
                        cell2 = (HSSFCell) cellIterator.next();
                        properties.put(key, cell2.getRichStringCellValue().toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return properties;
    }

    private static Properties props = getProperties();

    public String getProp(String key) {
        return props.getProperty(key);
    }

}
