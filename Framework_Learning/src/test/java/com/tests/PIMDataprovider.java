package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class PIMDataprovider {

	@DataProvider(name = "Addemployee",parallel = true)
	public String[][] Addemployeedataprovider() throws IOException{

//		String[][] data= new String[2][3];
//		data[0][0]="Bharadwaj";
//		data[0][1]="V";
//		data[0][2]="1234";
//		data[1][0]="Sharan";
//		data[1][1]="Kumar";
//		data[1][2]="5431";
//		return data;
//}
			File file=new File("./src/test/resources/config/datareadusingexcel.xlsx");
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("AddEmployee");
			
			int rows=sheet.getLastRowNum();//3
			
			int col=sheet.getRow(1).getLastCellNum();//3
			System.out.println(rows+" "+col);
			String[][] data =new String[rows][col];

			for(int i=1;i<=rows;i++) {
				XSSFRow row=sheet.getRow(i);
	
				for(int j=0;j<col;j++) {
					XSSFCell Cell=row.getCell(j);
					DataFormatter dataformat=new DataFormatter();
					String Value=dataformat.formatCellValue(Cell);
					data[i-1][j]=Value;

				}
			}
		
			return data;
			
		}

}