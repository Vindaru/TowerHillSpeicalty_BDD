package com.ths.actiondriver;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

	public static List<String> readFromExcel(String excelPath, String sheetName) throws Exception {
        List<String> policyNumbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(excelPath))) {
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
        }

        return policyNumbers;
    }

    public static void writeToExcel(String excelPath, String sheetName, List<String> policyNumbers, String newValue) throws Exception {
        try (FileInputStream fis = new FileInputStream(new File(excelPath))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowNum = getRowNumberForPolicy(sheet, policyNumbers);
            if (rowNum != -1) {
                Row row = sheet.getRow(rowNum);

                Cell cell;
                if (row.getCell(1) == null) {
                    cell = row.createCell(1);
                } else {
                    cell = row.getCell(1);
                }

                cell.setCellValue(newValue);
            } else {
                System.out.println("Policy number not found!");
                return;
            }

            try (FileOutputStream fos = new FileOutputStream(new File(excelPath))) {
                workbook.write(fos);
            }
        }
    }

    private static int getRowNumberForPolicy(Sheet sheet, List<String> policyNumbers) {
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.toString().trim().equals(policyNumbers)) {
                    return i;
                }
            }
        }
        return -1;  // return -1 if not found
    }

}
