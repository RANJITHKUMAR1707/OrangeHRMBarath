package TestNgpratice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExceldata {

	public static void main(String[] args) throws IOException {
		File file=new File("./src/test/resources/configfile/datareadusingexcel.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Basic");
		int rows=sheet.getLastRowNum();
		int col=sheet.getRow(1).getLastCellNum();

		for(int i=1;i<=rows;i++) {
			XSSFRow row=sheet.getRow(i);

			for(int j=0;j<col;j++) {

				XSSFCell Cell=row.getCell(j);

				switch (Cell.getCellType()) {

				case STRING:System.out.print(Cell.getStringCellValue());break;
				case NUMERIC:System.out.print(Cell.getNumericCellValue());break;
				case BOOLEAN:System.out.print(Cell.getBooleanCellValue());break;
				}
				System.out.print(" ");
			}

			System.out.println();
		}
	}

}
