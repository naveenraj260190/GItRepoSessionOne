package packageone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String FilePath = "C:\\Users\\ashna\\eclipse-workspace\\BaseClassSession"
			+ "\\Test_Data\\GroceryAutomation.xlsx";
	
		public void createCellAndSetData(String sheetName, int rownum, int cellnum, String data) throws Exception {
			File file = new File(FilePath);

			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(data);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			System.out.println("Updated has been done");
		}

		public void updateCellData(String sheetName, int rownum, int cellnum, 
				String oldData, String newData)
				throws IOException {
			File file = new File(FilePath);

			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			
			DataFormatter dataFormatter = new DataFormatter();
			String value = dataFormatter.formatCellValue(cell);
			if (value.equals(oldData)) {
				cell.setCellValue(newData);
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			System.out.println("updateCellData method executed and data has been updated ");
		}
		
					
		public static String getCellData(String sheetName, int rownum, int cellnum) throws Exception {
			
			File file = new File(FilePath);

			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			
			DataFormatter dataFormatter = new DataFormatter();
			String value = dataFormatter.formatCellValue(cell);
			return value;

		}
}
