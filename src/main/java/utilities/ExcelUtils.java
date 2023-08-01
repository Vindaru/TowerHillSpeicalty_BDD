package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bdd.variables.API_Constant_Values;

public class ExcelUtils{
	 
    public static XSSFSheet ExcelWSheet;

    public static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    
 
public static void setExcelFile(String Path,String SheetName) throws Exception {

  try {

      // Open the Excel file

FileInputStream ExcelFile = new FileInputStream(Path);

// Access the required test data sheet

ExcelWBook = new XSSFWorkbook(ExcelFile);

ExcelWSheet = ExcelWBook.getSheet(SheetName);

} catch (Exception e){

throw (e);

}

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	    public static String getCellData(int RowNum, int ColNum) throws Exception{

  try{

      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

      String CellData = Cell.getStringCellValue();

      return CellData;

      }catch (Exception e){

return"";

      }

}
	    
	    public static double getNumericCellValue(int RowNum, int ColNum) throws Exception{

	    	  try{

	    	      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

	    	      double CellData = Cell.getNumericCellValue();

	    	      return CellData;

	    	      }catch (Exception e){

	    	return ColNum;

	    	      }

	    	}

	    public  static java.sql.Date  getDateCellValue(int RowNum, int ColNum) throws Exception{
	    	
	    	  try{

	    	      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

	    	      Date CellData = Cell.getDateCellValue();

	    	      return (java.sql.Date) CellData;

	    	      }catch (Exception e){

	    	return null;

	    	      }

	    	}

//This method is to write in the Excel cell, Row num and Col num are the parameters

public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception {

  try{

      Row  = ExcelWSheet.getRow(RowNum);

Cell = Row.getCell(ColNum);

if (Cell == null) {

Cell = Row.createCell(ColNum);

Cell.setCellValue(Result);

} else {

Cell.setCellValue(Result);

}

     // Constant variables Test Data path and Test Data file name

FileOutputStream fileOut = new FileOutputStream(API_Constant_Values.DP1_Path_TestData + API_Constant_Values.DP1_File_TestData);

      ExcelWBook.write(fileOut);

      fileOut.flush();

fileOut.close();

}catch(Exception e){

throw (e);

}

}

}