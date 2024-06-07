package thetestingacdamy.DataDriverTesting;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;


public class Fileto2DArray {

    public static void main(String[] args) throws Exception{
        String sheetName = "Main";


        FileInputStream inputStream = new FileInputStream("CTD.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Main");

        int noOFRows = sheet.getLastRowNum()+1;
        int noOfCol  = sheet.getRow(0).getLastCellNum();

        String [][] dataTable =  new String[noOFRows][noOfCol];

        for (int i=0;sheet.getLastRowNum()+1>i;i++){
            Row row = sheet.getRow(i);
            for (int j =row.getFirstCellNum();j<row.getLastCellNum();j++){
                Cell cell = row.getCell(j);
                dataTable[i][j] = cell.getStringCellValue();
            }
        }

        for (String[] x:dataTable){
            for(String y:x){
                System.out.println(y);
            }
        }
    }

}