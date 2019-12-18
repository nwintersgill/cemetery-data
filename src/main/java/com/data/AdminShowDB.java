package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminShowDB {
	
	public static void main() {
		PreparedStatement s;
		Connection db = PQQuery.connectDB();
		try {
			s = db.prepareStatement("SELECT * from plot;");
			s.execute();
			
	} catch (SQLException e) {
		System.out.println("SQL exception, exiting ...");
		System.exit(1);
	}
	}
}
