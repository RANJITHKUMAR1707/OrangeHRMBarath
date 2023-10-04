package TestNgpratice;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * export data to excel file
 */
public class WriteExceldata {
	
	public static void main(String[] args) throws IOException {
	
		XSSFWorkbook workbook = new XSSFWorkbook();

	
		XSSFSheet sheet = workbook.createSheet("Sheet1");

		// Define data to be written as Strings
		String[][] data = {
				{"Name", "Age", "City"},
				{"John Doe", "30", "New York"},
				{"Jane Smith", "25", "Los Angeles"},
				{"Bob Johnson", "35", "Chicago"}
		};
		int rows=data.length;
		int cols=data[0].length;
		System.out.println(rows+" "+cols);

		
		for (int i = 0; i< rows; i++) {
			XSSFRow row = sheet.createRow(i);
			for (int j = 0; j< cols; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(data[i][j]);
			}
		}


		FileOutputStream outputStream = new FileOutputStream("./src/test/resources/config/Writedatausingexcel.xlsx");
		workbook.write(outputStream);
		System.out.println("Data written successfully to the Excel file.");

		workbook.close();


	}
}
