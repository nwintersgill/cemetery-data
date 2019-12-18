/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 11/23/2019
 * 
 * Package: Sort.java
 * Description: A class to contain the sort function of the plot table within our database
 */

package com.data;

import java.sql.*;
import java.util.ArrayList;

public class Sort {
	
	public static void SortFirst(ArrayList<Plot> plots) throws SQLException {
		int size = plots.size();
		for (int i = 0; i < size -1; i++) {
			for (int j = 0; j < size-i-1; j++) {
				Plot iPlot = plots.get(j);
				String iName = iPlot.getFirstName();
				Plot jPlot = plots.get(j + 1);
				String jName = jPlot.getFirstName();
				
				if (iName.compareTo(jName) > 0) {
				Plot temp = iPlot;
				plots.set(j, jPlot);
				plots.set(j+1, temp);
				}
			}
		}
	}
	
	public static void SortYear() throws SQLException {
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
