package org.Treshna.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	private Properties Properties;
	public String getDataFromThePropertyFile( String key) {

		String data = Properties.getProperty(key).trim();
		return data;


	}
	public void initializePropertyFile(String propertyFilePath) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties=new Properties();
		try {
			Properties.load(fis);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

}
