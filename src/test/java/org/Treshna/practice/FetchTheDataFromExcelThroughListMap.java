package org.Treshna.practice;

import java.util.List;
import java.util.Map;

import org.Treshna.genericUtility.ExcelUtility;
import org.Treshna.genericUtility.IConstantPath;

public class FetchTheDataFromExcelThroughListMap {

	public static void main(String[] args) {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.initializeExcelFile(IConstantPath.EXCEL_PATH);
		List<Map<String, String>> list=excelUtility.getDataFromExcelInListMap("Sheet1");
		System.out.println(list);
		
	}
}
