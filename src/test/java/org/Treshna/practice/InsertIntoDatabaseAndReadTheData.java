package org.Treshna.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertIntoDatabaseAndReadTheData {
	public static void main(String[] args) throws SQLException {

		//step1--->instance the driver class
		Driver dbdriver=new Driver();

		//step2---->register the driver reference to the jdbc
		DriverManager.registerDriver(dbdriver);

		//step3 ---->establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		
		
		//step4----->create the statement
		Statement statement = connection.createStatement();
		try {
			//step5---->execute the query
			int result = statement.executeUpdate("insert into employee values(3,'srinivas',7465365,'bangalore');");
		
			//step6--->fetch the data
			if (result==1) {
				System.out.println("record successfully updated");
			}
			
		} finally {
			connection.close();
			System.out.println("connection closed successfully");
		}
	
	}
}

