package org.Treshna.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadTheDataFromThePropertyFile {
public static void main(String[] args) throws IOException {
	//step 1------>create the physical file into jave readable file
	FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
	
	//step 2 ----->create the object for properties
	Properties property = new Properties();
	
	//step3 -------->load the file into property file
	property.load(fis);
	
	//step 4---->fetch the data 
	String url = property.getProperty("url").trim();
	
	System.out.println(url);
}
}
