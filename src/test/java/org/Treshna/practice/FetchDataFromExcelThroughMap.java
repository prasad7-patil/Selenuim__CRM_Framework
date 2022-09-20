package org.Treshna.practice;

import java.util.Map;

import org.Treshna.genericUtility.ExcelUtility;
import org.Treshna.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughMap {

	public static void main(String[] args) {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.initializeExcelFile(IConstantPath.EXCEL_PATH);
		Map<String, String> map=excelUtility.getDataFromExcelInMap("Sheet1");
		System.out.println(map.get("name"));
		
	}
}
