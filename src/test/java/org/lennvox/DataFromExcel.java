package org.lennvox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.BaseClass;
import org.testng.annotations.DataProvider;

public class DataFromExcel extends BaseClass{
	
	@DataProvider(name="data")
	public static Object[][] getDataExcel() throws IOException {
		Object[][] data = getData();
		return data;
		
	}

	public static Object[][]  getData() throws IOException {
		 File lc= new File("C:\\Users\\91908\\eclipse-workspace\\Lennvox\\src\\test\\resources\\Data.xlsx");
		 FileInputStream fis= new FileInputStream(lc);
		 Workbook w= new XSSFWorkbook(fis);
		 Sheet s= w.getSheet("sheet1");
		 Row r=s.getRow(1);
		 
		 int physicalNumberOfRows = s.getPhysicalNumberOfRows();
		 int physicalNumberOfCells = r.getPhysicalNumberOfCells();
		 Object obj[][] = new Object[physicalNumberOfRows - 1][physicalNumberOfCells];
		 
		 for (int i = 0; i < physicalNumberOfRows-1; i++) {
			 
			 Row row=s.getRow(i+1);
			 
			 for (int j = 0; j < physicalNumberOfCells; j++) {
				
				 Cell cell = row.getCell(j);
				 int type = cell.getCellType();
				 String value= null;
				 if(type==1) {
					 value = cell.getStringCellValue();
				 }
				 else if (DateUtil.isCellDateFormatted(cell)) {
					 Date date = cell.getDateCellValue();
					 SimpleDateFormat sf= new SimpleDateFormat("d-MMMM-yyyy");
					 value = sf.format(date);
				 }
				 else {
					double db =cell.getNumericCellValue();
					long l=(long) db;
					value = String.valueOf(l);
				}
				 obj[i][j] = value;
			}
			
		}
		 
		return obj;
		 
		 

	}
}
