package com.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminEdit {

	public static void editDB(String column, String newVal, String location) throws SQLException {
		PreparedStatement s;
		Connection db = PQQuery.connectDB();
		
		if (column.equalsIgnoreCase("birth") || column.equalsIgnoreCase("death") || column.equalsIgnoreCase("price")) {
			int val = Integer.parseInt(newVal);
			//creates an instance of the database to insert
			s = db.prepareStatement("UPDATE plot SET " + column + "= " + val + "WHERE location = " + location + ";");
			s.executeUpdate();
		}
		
		else { 
			s = db.prepareStatement("UPDATE plot SET " + column + "= " + newVal + "WHERE location = " + location + ";");
			s.executeUpdate();
		}
	}
}

