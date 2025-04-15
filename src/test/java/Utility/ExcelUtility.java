package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow Row;
    public static XSSFCell Cell;
    public static XSSFCellStyle style;

    /**
     * Returns the number of rows in the specified Excel sheet.
     * @param FilePath Path to the Excel file.
     * @param SheetName Name of the sheet.
     * @return Last row number (zero-based index).
     * @throws IOException If file operation fails.
     */
    public static int NumOfRowInSheet(String FilePath, String SheetName) throws IOException {
        fi = new FileInputStream(FilePath);
        wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet(SheetName);
        int LastRowNum = sheet.getLastRowNum(); // Get the last row index
        wb.close();
        fi.close();
        return LastRowNum;
    }

    /**
     * Returns the number of cells in a given row of the Excel sheet.
     * @param FilePath Path to the Excel file.
     * @param SheetName Name of the sheet.
     * @param row Row index (zero-based).
     * @return Number of cells in the row.
     * @throws IOException If file operation fails.
     */
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

    /**
     * Retrieves data from a specified cell in the Excel sheet.
     * @param FilePath Path to the Excel file.
     * @param SheetName Name of the sheet.
     * @param row Row index (zero-based).
     * @param cell Column index (zero-based).
     * @return Cell value as a String.
     * @throws IOException If file operation fails.
     */
    public static String GetData(String FilePath, String SheetName, int row, int cell) throws IOException {
        fi = new FileInputStream(FilePath);
        wb = new XSSFWorkbook(fi);
        String value="";
        sheet = wb.getSheet(SheetName);
        Row=sheet.getRow(row);
       if(Row!=null)
        {	Cell =sheet.getRow(row).getCell(cell);
        	if(Cell!=null){
          value = sheet.getRow(row).getCell(cell).toString();
        }
        }     
        wb.close();
        fi.close();
        return value;
    }

    /**
     * Writes data to a specified cell in the Excel sheet.
     * @param FilePath Path to the Excel file.
     * @param SheetName Name of the sheet.
     * @param row Row index (zero-based).
     * @param cell Column index (zero-based).
     * @param value Data to be written.
     * @throws IOException If file operation fails.
     */
    public static void GetDataANDFeedData(String FilePath, String SheetName, int row, int cell, String value) throws IOException {
        fi = new FileInputStream(FilePath);
        wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet(SheetName);
        
        // Ensure row exists before creating a cell
        Row = sheet.getRow(row);
        if (Row == null) {
            Row = sheet.createRow(row);
        }

        Row.createCell(cell).setCellValue(value); // Write value to the specified cell
        
        fo = new FileOutputStream(FilePath);
        wb.write(fo); // Save changes
        wb.close();
        fi.close();
        fo.close();
    }

    /**
     * Sets background color of a specified cell.
     * @param FilePath Path to the Excel file.
     * @param SheetName Name of the sheet.
     * @param row Row index (zero-based).
     * @param cell Column index (zero-based).
     * @param color IndexedColors enum for color selection.
     * @throws IOException If file operation fails.
     */
    public static void SetCellColor(String FilePath, String SheetName, int row, int cell, IndexedColors color) throws IOException {
        fi = new FileInputStream(FilePath);
        wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet(SheetName);

        // Ensure row exists before creating a cell
        Row = sheet.getRow(row);
        if (Row == null) {
            Row = sheet.createRow(row);
        }

        // Create a cell style with the selected color
        style = wb.createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Apply the style to the cell
        Row.createCell(cell).setCellStyle(style);

        fo = new FileOutputStream(System.getProperty("user.dir") + FilePath);
        wb.write(fo); // Save changes
        wb.close();
        fi.close();
        fo.close();
    }

    /**
     * Sets the background color of a specified cell to green.
     * @param FilePath Path to the Excel file.
     * @param SheetName Name of the sheet.
     * @param row Row index (zero-based).
     * @param cell Column index (zero-based).
     * @throws IOException If file operation fails.
     */
    public static void SetGreenColorToCell(String FilePath, String SheetName, int row, int cell) throws IOException {
        SetCellColor(FilePath, SheetName, row, cell, IndexedColors.GREEN);
    }

    /**
     * Sets the background color of a specified cell to red.
     * @param FilePath Path to the Excel file.
     * @param SheetName Name of the sheet.
     * @param row Row index (zero-based).
     * @param cell Column index (zero-based).
     * @throws IOException If file operation fails.
     */
    public static void SetRedColorToCell(String FilePath, String SheetName, int row, int cell) throws IOException {
        SetCellColor(FilePath, SheetName, row, cell, IndexedColors.RED);
    }
}
