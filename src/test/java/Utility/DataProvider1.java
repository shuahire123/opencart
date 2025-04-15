package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider1 {
	 public static FileInputStream fi;
	    public static FileOutputStream fo;
	    public static XSSFWorkbook wb;
	    public static XSSFSheet sheet;
	    public static XSSFRow Row;
	    public static XSSFCellStyle style;
	    public static int NumOfRowInSheet(String FilePath, String SheetName) throws IOException {
	        fi = new FileInputStream(FilePath);
	        wb = new XSSFWorkbook(fi);
	        sheet = wb.getSheet(SheetName);
	        int LastRowNum = sheet.getLastRowNum(); // Get the last row index
	        wb.close();
	        fi.close();
	        return LastRowNum;
	    }
	    public static int NumOfCellInSheet(String FilePath, String SheetName, int row) throws IOException {
	        fi = new FileInputStream(FilePath);
	        wb = new XSSFWorkbook(fi);
	        sheet = wb.getSheet(SheetName);
	        Row = sheet.getRow(row);
	        int LastCellNum = (Row != null) ? Row.getLastCellNum() : 0; // Handle null row case
	        wb.close();
	        fi.close();
	        return LastCellNum;
	    }
	    
	    public static String GetData(String FilePath, String SheetName, int row, int cell) throws IOException {
	        fi = new FileInputStream(FilePath);
	        wb = new XSSFWorkbook(fi);
	        sheet = wb.getSheet(SheetName);
	        String value = sheet.getRow(row).getCell(cell).toString();
	        wb.close();
	        fi.close();
	        return value;
	    }
	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\shuah\\eclipse-SeleniumAndJava\\OpenCart\\TestData\\OpenCartTestData.xlsx";
		int Rows=NumOfRowInSheet(path,"Sheet1");
		int Cells= NumOfCellInSheet(path, "Sheet1", 0);
		Object [][] data= new Object[Rows][Cells];
		for(int i=1;i<=Rows;i++)
		{
			for(int j=0;j<=Cells;j++)
			{
				data[i-1][j]=GetData(path, "Sheet1", i, j);
			}
		}
		for(Object [] d:data)
		{
			for(Object c:d)
			{
				System.out.print(c+" ");
			}
			System.out.println();
		}
		
	}
}
