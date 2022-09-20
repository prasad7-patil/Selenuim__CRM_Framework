package org.Treshna.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//step 1------>create the physical file into jave readable file
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
	
	//step 2--->open the excel workbook
	Workbook wb = WorkbookFactory.create(fis);
	
	//step 3--->get sheet name
	Sheet sheet = wb.getSheet("commondata");
	
	//step 4---->get row
	Row row = sheet.getRow(1);
	
	//step 5----->get cell
	Cell cell = row.getCell(1);
	
	//step6---->fetch the data
	System.out.println(cell.getStringCellValue());
	
}
}
