package plot;

import java.util.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.*;

public class Search {
	
	//iterate through the first name, last name, or spouses name in the database
	public Search(String name) {
	//initialize the database and search details 
		dbConnection = connectDB();
		PreparedStatement firstSearch = dbConnection.preparedStatement("SELECT * FROM Plot WHERE First = ?");
		PreparedStatement lastSearch = dbConnection.preparedStatement("SELECT * FROM Plot WHERE Last = ?");
		firstSearch.setString(1, name);
		lastSearch .setString(1, name);
		ResultSet dbFirst = firstSearch.executeQuery();
		ResultSet dbLast = lastSearch.executeQuery();
		
		//create a list of strings with matching results 
		List<String> firstResults = new ArrayList<>();
		List<String> lastResults = new ArrayList<>();
		
		//while there is something next in the database check that it matches the search
		while (dbFirst.next()) {
			String curFirst = dbFirst.getString("First");
			firstResults.add(curFirst);
		}
		while (dbLast.next()) {
			String curLast = dbLast.getString("Last");
			lastResults.add(curLast);
		}
		
		//return our results
		for (String curName: firstResults) {
			System.out.println(curName);
		}
		for (String curName: lastResults) {
			System.out.println(curName);
		}
	}
	
	public Search(int year) {
		//iterate through the birth year and death year
		dbConnection = connnectDB();
		PreparedStatement bYearSearch = dbConnection.preparedStatement("SELECT * FROM Plot where Birth Year = ?");
		PreparedStatement dYearSearch = dbConnection.preparedStatement("SELECT * FROM Plot where Death Year = ?");
		bYearSearch.setString(1, Integer.toString(year));
		dYearSearch .setString(1,  Integer.toString(year));
		ResultSet bYearResults = bYearSearch.executeQuery();
		ResultSet dYearResults = dYearSearch.executeQuery();
		
		//list of strings for matching results
		List<String> birthResults = new ArrayList<>();
		List<String> deathResults = new ArrayList<>();
		
		//while there is something next in the database check if it matches the search
		while (bYearResults.next()) {
			String curBirth = bYearResults.getString("Birth Year");
			birthResults.add(curBirth);
		}
		
		while (dYearResults.next()) {
			String curDeath = dYearResults.getString("Death Year");
			deathResults.add(curDeath);
		}
		
		//return results
		for (String curDate: birthResults) {
			System.out.println(curDate);
		}
		for (String curDate: deathResults) {
			System.out.println(curDate);
		}
	}
}
