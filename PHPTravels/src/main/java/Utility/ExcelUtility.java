package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook excelWbook;
	public static XSSFSheet excelWsheet;
	
public static String getCellData(int RowNum,int ColNum,String ExcelPath,int SheetNum) throws IOException 
{		
		FileInputStream Excel = new FileInputStream(ExcelPath);
		excelWbook = new XSSFWorkbook(Excel);
		excelWsheet = excelWbook.getSheetAt(SheetNum);
	
	return excelWsheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
}
	
public static String getNumericData(int RowNum,int ColNum,String ExcelPath,int SheetNum) throws IOException 
{	
	FileInputStream Excel = new FileInputStream(ExcelPath);
	excelWbook = new XSSFWorkbook(Excel);
	excelWsheet = excelWbook.getSheetAt(SheetNum);

return excelWsheet.getRow(RowNum).getCell(ColNum).getRawValue();
}


}
