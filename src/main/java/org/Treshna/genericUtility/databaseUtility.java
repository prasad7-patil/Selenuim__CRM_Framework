package org.Treshna.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class databaseUtility {
	private Connection connection;

	public List<String> getdataFromDatabase(String query,String column_name) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list=new ArrayList<>();
		while (result.next()) {
			list.add(result.getString(column_name));
		}
		return list;
	}
	public void openDbConnection(String dbUrl,String dbUsername, String dbPassword) throws SQLException {
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

	}
	public void closeDb() throws SQLException {
		connection.close();
	}
	
	public void insertDataIntoExcel(String query) throws SQLException {
		Statement statement = connection.createStatement();
		try {
			//step5---->execute the query
			int result = statement.executeUpdate(query);
		
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
