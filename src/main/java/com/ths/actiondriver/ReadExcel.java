
package com.ths.actiondriver;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public static List<String> getPolicyNumbersFromExcel(String filePath, String sheetName) throws Exception {
        List<String> policyNumbers = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    policyNumbers.add(cell.toString().trim());
                }
            }
        }

        workbook.close();
        fis.close();

        return policyNumbers;
    }
}
