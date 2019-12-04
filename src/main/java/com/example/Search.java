package com.example;

import java.util.*;
import java.sql.*;

public class Search {
	
	//iterate through the first name, last name, or spouses name in the database
	public Search(String name) {
		//initialize the connection and statements 
		Connection dbConnection = PQQuery.connectDB();
		PreparedStatement firstSearch;
		PreparedStatement lastSearch;

		//create a list of strings with matching results 
		List<String> firstResults = new ArrayList<>();
		List<String> lastResults = new ArrayList<>();
		
		try {
			//set the statements to search through specified columns
			firstSearch = dbConnection.prepareStatement("SELECT * FROM Plot WHERE First = ?");
			lastSearch = dbConnection.prepareStatement("SELECT * FROM Plot WHERE Last = ?");
			firstSearch.setString(1, name);
			lastSearch.setString(1, name);
		
			//get results from the database
			ResultSet dbFirst = firstSearch.executeQuery();
			ResultSet dbLast = lastSearch.executeQuery();
			
			//while there is something next in the results check if it matches the search
			while (dbFirst.next()) {
				String curFirst = dbFirst.getString("First");
				firstResults.add(curFirst);
			}
			while (dbLast.next()) {
				String curLast = dbLast.getString("Last");
				lastResults.add(curLast);
			}
		} catch (SQLException e) {
			System.out.println("SQLException, exiting ...");
			System.exit(1);
		}
		
		//return our results
		for (String curName: firstResults) {
			System.out.println(curName);
		}
		for (String curName: lastResults) {
			System.out.println(curName);
		}
	}
	
	//iterate through the birth year and death year
	public Search(int year) {
		//initialize connection and statements
		Connection dbConnection = PQQuery.connectDB();
		PreparedStatement bYearSearch;
		PreparedStatement dYearSearch;
		
		//list of strings for matching results
		List<String> birthResults = new ArrayList<>();
		List<String> deathResults = new ArrayList<>();
		
		try {
			//set the statements to search through specified columns
			bYearSearch = dbConnection.prepareStatement("SELECT * FROM Plot where Birth Year = ?");
			dYearSearch = dbConnection.prepareStatement("SELECT * FROM Plot where Death Year = ?");
			bYearSearch.setString(1, Integer.toString(year));
			dYearSearch.setString(1,  Integer.toString(year));
			
			//get the results from the database
			ResultSet bYearResults = bYearSearch.executeQuery();
			ResultSet dYearResults = dYearSearch.executeQuery();
		
			//while there is something next in the database check if it matches the search
			while (bYearResults.next()) {
				String curBirth = bYearResults.getString("Birth Year");
				birthResults.add(curBirth);
			}
			
			while (dYearResults.next()) {
				String curDeath = dYearResults.getString("Death Year");
				deathResults.add(curDeath);
			}
		} catch (SQLException e) {
			System.out.println("SQLException, exiting ...");
			System.exit(1);
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
