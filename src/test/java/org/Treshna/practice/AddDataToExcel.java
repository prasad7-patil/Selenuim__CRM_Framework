package org.Treshna.practice;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddDataToExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	
	Sheet sheet = wb.getSheet("organization");
	
	Row row = sheet.getRow(7);
	
	Cell cell = row.createCell(3);
	cell.setCellValue("hello");
	
	FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
	wb.write(fos);
	
	System.out.println("successfully udated the data");
	
	wb.close();
	
	
}
}
