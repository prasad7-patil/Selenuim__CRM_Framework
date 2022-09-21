package org.Treshna.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//hello changes are done in excel utility
<<<<<<< HEAD
//hello2
=======
>>>>>>> branch 'project1' of https://github.com/prasad7-patil/Treshna.git
/**
 * @param
 * This Class consists of all common action that are required to fetch data from excel
 * @author Admin
 *
 */
public class ExcelUtility {
	private FileInputStream fis=null;
	private Workbook workbook=null;
	private FileOutputStream fos=null;;

	/**
	 * this method helps to write the data in excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param columnNumber
	 * @return
	 * 
	 */ 
	public String getDataFromExcel( String sheetName, int rowNumber, int columnNumber ) {

		Sheet sheet = workbook.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(columnNumber));
		return data;

	}
	/**
	 * This method is used to write the data into excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param columnNumber
	 * @param status
	 */

	public void writeDataInExcel( String sheetName, int rowNumber, int columnNumber,String data) {

		Sheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(rowNumber).createCell(columnNumber).setCellValue(data);

		}
	/**
	 * this method helps to save the excel
	 */
	public void saveExcel() {
		try {
			fos = new FileOutputStream(IConstantPath.EXCEL_PATH);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * this method helps to initializa the excel
	 * @param excelPath
	 */
	public void initializeExcelFile(String excelPath)  {
		try {
			fis=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method helps to close the excel
	 */
	public void closeExcelWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to get the data from excel and store it in List<Map>
	 * @param sheetName
	 * @return
	 */
	public List<Map<String, String>> getDataFromExcelInListMap(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);

		DataFormatter df=new DataFormatter();
		List<Map<String,String>> list=new ArrayList<>();
		for (int k=1; k<sheet.getRow(0).getLastCellNum(); k++) {
			Map<String,String> map = new HashMap<>();
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));


			}
			list.add(map);
		}
		return list;
	}
/**
 * this method helps to get data from excel when data in excel is in key and value pair
 * @param sheetName
 * @param requiredKey
 * @return
 */
	public  String getDataFromExcel(String sheetName,String requiredKey) {
		Sheet sheet = workbook.getSheet(sheetName);
		String value=null;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			String actualKey = sheet.getRow(i).getCell(i).getStringCellValue();
			if (actualKey.equalsIgnoreCase(requiredKey)) {
				sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}

		}
		return value;
	}
	
	/**
	 * this method helps to get the data from the excel when the data in excel is written in horizontal manner
	 * @param sheetName
	 * @param requiredTestCaseName
	 * @param requiredKeyName
	 * @return
	 */

	public String getDataFromDataFromExcel(String sheetName,String requiredTestCaseName,String requiredKeyName) {
		Sheet sheet = workbook.getSheet(sheetName);
		String value=null;
		for (int i = 0; i<=sheet.getLastRowNum(); i++) {
			String actualTestCaseName=sheet.getRow(i).getCell(0).getStringCellValue();
			if (actualTestCaseName.equalsIgnoreCase(requiredTestCaseName)) {
				for (int j = 1; j<sheet.getRow(i).getLastCellNum(); j++) {
					String actualKeyName=sheet.getRow(i).getCell(j).getStringCellValue();
					if (actualKeyName.equalsIgnoreCase(requiredKeyName)) {
						value=sheet.getRow(i+1).getCell(j).getStringCellValue();
						break;

					}
			
				}
				break;
			}	
		}
		return value;	
	}

	public Map<String, String> getDataFromExcelInMap(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		Map<String,String> map=new HashMap<String, String>();
		DataFormatter df=new DataFormatter();
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {

			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));

		}
		return map;
	}



}


