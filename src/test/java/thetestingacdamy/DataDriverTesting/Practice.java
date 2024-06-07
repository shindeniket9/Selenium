package thetestingacdamy.DataDriverTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Practice {
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream(new File("CTD.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Main");

        int noOfRow = sheet.getLastRowNum()+1;
        int noOfCol = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRow][noOfCol];

        for (int i=0;i<sheet.getLastRowNum()+1;i++){
            Row row = sheet.getRow(i);
            for(int j = row.getFirstCellNum();j<row.getLastCellNum();j++){
                Cell cell = row.getCell(j);
                data[i][j]= cell.getStringCellValue();
            }
        }

        for(String[] x:data){
            for(String y:x){
                System.out.println(y);
            }
        }
    }
}
