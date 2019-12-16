/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 11/23/2019
 * 
 * Package: Sort.java
 * Description: A class to contain the sort function of the plot table within our database
 */

package com.data;

import java.sql.*;

public class Sort {
	
	public void SortName() throws SQLException {
		//connect to the database
		Connection dbConnection = PQQuery.connectDB();
		
		//execute a query by selecting the columns 'First' and 'Last' from the table named Plot
		Statement stmt = dbConnection.createStatement();
		String string = "SELECT First, Last FROM Plot" + " ORDER BY first ASC";
		ResultSet results = stmt.executeQuery(string);

		//return results by column name
		while (results.next()) {
			String first = results.getString("First");
			String last = results.getString("Last");
			
			System.out.println("First Name: " + first);
			System.out.println("Last Name: " + last);
		}
		
		if (stmt != null) {
			dbConnection.close();
		}
	}
	
	public void SortYear() throws SQLException {
		//connect to the database
		Connection dbConnection = PQQuery.connectDB();
		
		//execute a query by selecting the column 'Age' from the table named Plot
		Statement stmt = dbConnection.createStatement();
		String string = "SELECT Death Year FROM Plot" + " ORDER BY first ASC";
		ResultSet results = stmt.executeQuery(string);
		
		//return results by column name
		while (results.next()) {
			int year = results.getInt("Age");
			
			System.out.println("Death Year: " + year);
		}
	}

}
