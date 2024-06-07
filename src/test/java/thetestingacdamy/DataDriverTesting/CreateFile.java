package thetestingacdamy.DataDriverTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


// Below code for specific cell

//XSSFWorkbook workbook = new XSSFWorkbook();
//XSSFSheet sheet = workbook.createSheet("Main");
//
//Row row   = sheet.createRow(1);
//Cell cell = sheet.createCell(1);
//cell.setCellValue("ABC");
//
//FileOutputStream outputStream = new FileOutputStream(new File("CTD.xlsx"));
//        workbook.write(outputStream);
//        outputStream.close();


public class CreateFile {

    public static void main(String[] args) throws Exception {

        // workbook - sheet - row - cell
        // CTD - Main - Row/Column - cell


        Map<String,Object> data = new TreeMap<>();
        data.put("1",new Object[]{"LoginID","Email","Password"});
        data.put("2",new Object[]{"1","abc@1","Password1"});
        data.put("3",new Object[]{"2","abc@2","Password2"});

        Set<String> Keyset = data.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        int rownum = 0;

        for(String Key: Keyset){
            Row r = sheet.createRow(rownum++);
            Object[] objectA = (Object[]) data.get(Key);

            int cellnum =0;
            for(Object o:objectA){
             Cell cell = r.createCell(cellnum++);
             cell.setCellValue((String)o);
            }
        }

        FileOutputStream outputStream = new FileOutputStream(new File("CTD.xlsx"));
        workbook.write(outputStream);
        outputStream.close();

    }
}
