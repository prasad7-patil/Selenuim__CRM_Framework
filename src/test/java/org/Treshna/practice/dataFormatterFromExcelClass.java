package org.Treshna.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class dataFormatterFromExcelClass {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		try {
			Cell cell = wb.getSheet("Sheet1").getRow(0).getCell(0);
			String cellValue = df.formatCellValue(cell);
			 System.out.println(cellValue);
			
		} finally {
			wb.close();
		}
		
		 

	}
}
