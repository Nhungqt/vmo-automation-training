package com.vmo.demowebshop.utils.excelutils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
public class ExcelUtil {
    public final String currentDir = System.getProperty("user.dir");

    public String testDataExcelFileName;
    public String testDataExcelPath;
    private XSSFWorkbook excelWBook;
    private XSSFSheet excelWSheet;
    private XSSFCell cell;
    private XSSFRow row;

    public int rowNumber;
    public int columnNumber;

    public String columnName;

    private HashMap<String, Integer> columnsHeader = new HashMap<String, Integer>();
    public static ExcelUtil shared = new ExcelUtil();
    public void setExcelFileSheet(String excelFileName, String sheetName) {
        testDataExcelFileName = excelFileName;
        try {
            if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
                testDataExcelPath = currentDir + "/src/test/resources/";
            } else if (Platform.getCurrent().toString().toUpperCase().contains("WIN")) {
                testDataExcelPath = currentDir + "\\src\\test\\resources\\";
            }

            FileInputStream excelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);

            excelWSheet.getRow(0).forEach(cell -> {
                columnsHeader.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String getCellData(int RowNum, int ColNum) {
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public String getCellData(int RowNum, String ColName) {
        return getCellData(RowNum, columnsHeader.get(ColName));
    }

    public XSSFRow getRowData(int RowNum) {
        row = excelWSheet.getRow(RowNum);
        return row;
    }

    public int getTotalRow() {
        return excelWSheet.getPhysicalNumberOfRows();
    }

    public int getTotalColumn() {
        return excelWSheet.getRow(0).getLastCellNum();
    }

    public void setCellData(String value, int RowNum, int ColNum) {
        row = excelWSheet.getRow(RowNum);
        cell = row.getCell(ColNum);
        if (cell == null) {
            cell = row.createCell(ColNum);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void setCellData(String value, int RowNum, String ColName) {
        if(ColName != null && !ColName.isEmpty() && !ColName.isBlank()) {
            setCellData(value, RowNum, columnsHeader.get(ColName));
        }
    }

    public Object[][] getExcelData(String excelFileName, String sheetName) {
        Object[][] data;
        setExcelFileSheet(excelFileName, sheetName);
        try {
            row = excelWSheet.getRow(0);

            int noOfRows = excelWSheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();

            data = new Object[noOfRows - 1][noOfCols];

            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = excelWSheet.getRow(i);
                    cell = row.getCell(j);

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BLANK:
                        case STRING:
                        default:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return data;
    }

    public Object[][] getExcelData(String excelFileName, String sheetName, int startRow,int endRow, int startColumn, int endColumn) {
        Object[][] data;
        setExcelFileSheet(excelFileName, sheetName);
        try {
            row = excelWSheet.getRow(0);

            int noOfRows = excelWSheet.getPhysicalNumberOfRows() - 1;
            int noOfCols = row.getLastCellNum() - 1;
            if (endRow < noOfRows){
                noOfRows = endRow;
            }
            if (endColumn < noOfCols){
                noOfCols = endColumn;
            }
            data = new Object[noOfRows - startRow + 1][noOfCols - startColumn + 1];

            for (int i = startRow; i <= noOfRows; i++) {
                for (int j = startColumn; j <= noOfCols; j++) {
                    row = excelWSheet.getRow(i);
                    cell = row.getCell(j);

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            double value = cell.getNumericCellValue();
                            if (value == (int)value){
                                data[i - startRow][j-startColumn] = String.valueOf((int)value);
                            }else{
                                data[i - startRow][j-startColumn] = String.valueOf(value);
                            }

                            break;
                        case BLANK:
                        case STRING:
                        default:
                            data[i - startRow][j-startColumn] = cell.getStringCellValue();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return data;
    }
}
