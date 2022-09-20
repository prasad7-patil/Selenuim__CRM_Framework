package org.Treshna.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadTheDataFromMySql {
	public static void main(String[] args) throws SQLException {
		//step 1--->instantiate the Driver class from mysql.cj.jdbc
		Driver dbDrivers=new Driver();

		//step 2---->register the Driver reference variable to the jdbc
		DriverManager.registerDriver(dbDrivers);

		//step3----> establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");

		//step-4----->create the statement
		Statement statement = connection.createStatement();
		try {
			//step-5--->execute the query
			ResultSet result = statement.executeQuery("select emp_name from employee;");

			//step6--->fetch the each data
			while (result.next()) {
				System.out.println(result.getString("emp_name"));
			}
		} finally {
			// step 7 ----> close the db connection
			connection.close();
			System.out.println("connection closed successfully"); 
		}

	}
}
