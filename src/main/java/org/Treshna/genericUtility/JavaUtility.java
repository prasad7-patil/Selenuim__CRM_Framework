package org.Treshna.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * this method is used to get random number
	 * @param limit
	 * @return
	 */

	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);

	}

	/**
	 * this method is used to convert string to any datatype
	 * @param data
	 * @param Strategy
	 * @return
	 */
	public Object convertStringIntoAnyDatatype(String data, DataType Strategy) {
		Object obj=null;
		if (Strategy.toString().equalsIgnoreCase("long")) {
			obj=Long.parseLong(data);
		}else if (Strategy.toString().equalsIgnoreCase("int")) {
			obj=Integer.parseInt(data);
		}else if (Strategy.toString().equalsIgnoreCase("double")) {
			obj=Double.parseDouble(data);
		}
		return obj;
	}
	/**
	 * This method is used to get the current time 
	 * @return
	 */

	public String currentTime() {
		Date date=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String time = sdf.format(date);
		return time;
	}
	
	/** 
	 * This method is used to split the e.g.,03:00:AM into separate element
	 * @param time
	 * @return 
	 * @return
	 */
	public String[] splitTheTimeInHHMMFormat(String time){
		String str=time;
		String[] value = str.split(":");
		return value;
	}
}
