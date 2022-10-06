package org.Treshna.genericUtility;

public interface IConstantPath {
//variable method -------->camel case
//class interface ENUM ANNOTATION------>pascal case
//static and final---->capital
/**
 * This interface consist of all path related to excel and property
 */
	String EXCEL_PATH=System.getProperty("user.dir")+"/src/test/resources/campaign.testdata.xlsx";
	String PROPERTY_PATH=System.getProperty("user.dir")+"/src/test/resources/commondata.properties";
}
