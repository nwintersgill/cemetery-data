/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 12/2/2019
 * 
 * Package: Search.java
 * Description: A class to contain the search function of the plot table within our database
 * 				Given a plot extrats the attributes from that plot and compares them to values
 * 				currently in the database
 */

package com.data;

import java.util.*;
import java.sql.*;

public class Search {
	
	//iterate through the first, middle, and last names in the database
	public static ArrayList<Plot> SearchDB(Plot plot) {
		//initialize the connection and statements 
		Connection dbConnection = PQQuery.connectDB();
		PreparedStatement firstSearch;
		PreparedStatement middleSearch;
		PreparedStatement lastSearch;
		PreparedStatement locationSearch;
		PreparedStatement birthSearch;
		PreparedStatement deathSearch;
		
	
		//initialize result sets
		ResultSet db;
		
		//get attributes from input
		String firstName = plot.getFirstName();
		String middleName = plot.getMiddleName();
		String lastName = plot.getLastName();
		String location = plot.getLocation();
		int birthYear = plot.getBirthYear();
		int deathYear = plot.getDeathYear();
		
		//return our results
		ArrayList<Plot> plotList = new ArrayList<>();
		ArrayList<Plot> finalList = new ArrayList<>();
		String record = null;
		
		try {
			//set the statements to search through specified columns
			if (firstName != null) {
				record = "first";
				firstSearch = dbConnection.prepareStatement("SELECT first, middle, last, spouse, location, notes, birth, death FROM Plot WHERE first = ?;");
				firstSearch.setString(1, firstName);
				db = firstSearch.executeQuery();
				while (db.next()) {
					Plot curPlot = new Plot();
					
					String first = db.getString("first");
					curPlot.setFirstName(first);
					
					String middle = db.getString("middle");
					curPlot.setMiddleName(middle);
					
					String last = db.getString("last");
					curPlot.setLastName(last);
					
					String spouse = db.getString("spouse");
					curPlot.setSpouse(spouse);
					
					String plLocation = db.getString("location");
					curPlot.setLocation(plLocation);
					
					String notes = db.getString("notes");
					curPlot.setNotes(notes);
					
					int bYear = db.getInt("birth");
					curPlot.setBirthYear(bYear);
					
					int dYear = db.getInt("death");
					curPlot.setDeathYear(dYear);
					
					plotList.add(curPlot);
				}
			}
			
			else if (lastName != null) {
				record = "last";
				lastSearch = dbConnection.prepareStatement("SELECT first, middle, last, spouse, location, notes, birth, death FROM Plot WHERE last = ?;");
				lastSearch.setString(1, lastName);
				db = lastSearch.executeQuery();
				while (db.next()) {
					Plot curPlot = new Plot();
					
					String first = db.getString("first");
					curPlot.setFirstName(first);
					
					String middle = db.getString("middle");
					curPlot.setMiddleName(middle);
					
					String last = db.getString("last");
					curPlot.setLastName(last);
					
					String spouse = db.getString("spouse");
					curPlot.setSpouse(spouse);
					
					String plLocation = db.getString("location");
					curPlot.setLocation(plLocation);
					
					String notes = db.getString("notes");
					curPlot.setNotes(notes);
					
					int bYear = db.getInt("birth");
					curPlot.setBirthYear(bYear);
					
					int dYear = db.getInt("death");
					curPlot.setDeathYear(dYear);
					
					plotList.add(curPlot);
				}
			}
			
			else if (middleName != null) {
				record = "middle";
				middleSearch = dbConnection.prepareStatement("SELECT first, middle, last, spouse, location, notes, birth, death FROM Plot WHERE middle = ?;");
				middleSearch.setString(1, middleName);
				db = middleSearch.executeQuery();
				while (db.next()) {
					Plot curPlot = new Plot();
					
					String first = db.getString("first");
					curPlot.setFirstName(first);
					
					String middle = db.getString("middle");
					curPlot.setMiddleName(middle);
					
					String last = db.getString("last");
					curPlot.setLastName(last);
					
					String spouse = db.getString("spouse");
					curPlot.setSpouse(spouse);
					
					String plLocation = db.getString("location");
					curPlot.setLocation(plLocation);
					
					String notes = db.getString("notes");
					curPlot.setNotes(notes);
					
					int bYear = db.getInt("birth");
					curPlot.setBirthYear(bYear);
					
					int dYear = db.getInt("death");
					curPlot.setDeathYear(dYear);
					
					plotList.add(curPlot);
				}
			}
			
			else if (location != null) {
				record = "location";
				locationSearch = dbConnection.prepareStatement("SELECT first, middle, last, spouse, location, notes, birth, death FROM Plot WHERE location = ?;");
				locationSearch.setString(1, location);
				db = locationSearch.executeQuery();
				while (db.next()) {
					Plot curPlot = new Plot();
					
					String first = db.getString("first");
					curPlot.setFirstName(first);
					
					String middle = db.getString("middle");
					curPlot.setMiddleName(middle);
					
					String last = db.getString("last");
					curPlot.setLastName(last);
					
					String spouse = db.getString("spouse");
					curPlot.setSpouse(spouse);
					
					String plLocation = db.getString("location");
					curPlot.setLocation(plLocation);
					
					String notes = db.getString("notes");
					curPlot.setNotes(notes);
					
					int bYear = db.getInt("birth");
					curPlot.setBirthYear(bYear);
					
					int dYear = db.getInt("death");
					curPlot.setDeathYear(dYear);
					
					plotList.add(curPlot);
				}
			}
			else if (birthYear != -1) {
				record = "birth";
				birthSearch = dbConnection.prepareStatement("SELECT first, middle, last, spouse, location, notes, birth, death FROM Plot WHERE birth = ?;");
				birthSearch.setInt(1, birthYear);
				db = birthSearch.executeQuery();
				while (db.next()) {
					Plot curPlot = new Plot();
					
					String first = db.getString("first");
					curPlot.setFirstName(first);
					
					String middle = db.getString("middle");
					curPlot.setMiddleName(middle);
					
					String last = db.getString("last");
					curPlot.setLastName(last);
					
					String spouse = db.getString("spouse");
					curPlot.setSpouse(spouse);
					
					String plLocation = db.getString("location");
					curPlot.setLocation(plLocation);
					
					String notes = db.getString("notes");
					curPlot.setNotes(notes);
					
					int bYear = db.getInt("birth");
					curPlot.setBirthYear(bYear);
					
					int dYear = db.getInt("death");
					curPlot.setDeathYear(dYear);
					
					plotList.add(curPlot);
				}
			}
			else if (deathYear != -1) {
				record = "death";
				deathSearch = dbConnection.prepareStatement("SELECT first, middle, last, spouse, location, notes, birth, death FROM Plot WHERE death = ?;");
				deathSearch.setInt(1, deathYear);
				db = deathSearch.executeQuery();
				while (db.next()) {
					Plot curPlot = new Plot();
					
					String first = db.getString("first");
					curPlot.setFirstName(first);
					
					String middle = db.getString("middle");
					curPlot.setMiddleName(middle);
					
					String last = db.getString("last");
					curPlot.setLastName(last);
					
					String spouse = db.getString("spouse");
					curPlot.setSpouse(spouse);
					
					String plLocation = db.getString("location");
					curPlot.setLocation(plLocation);
					
					String notes = db.getString("notes");
					curPlot.setNotes(notes);
					
					int bYear = db.getInt("birth");
					curPlot.setBirthYear(bYear);
					
					int dYear = db.getInt("death");
					curPlot.setDeathYear(dYear);
					
					plotList.add(curPlot);
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException, exiting ...");
			System.exit(1);
		}
		
		if (record.equalsIgnoreCase("first")) {
			while (!plotList.isEmpty()) {
				Plot curPlot = plotList.remove(0);
				if (curPlot.getLastName().equalsIgnoreCase(lastName) || lastName == null) {
					if (curPlot.getMiddleName().equalsIgnoreCase(middleName) || middleName == null) {
						if (curPlot.getLocation().equalsIgnoreCase(location) || location == null) {
							if (curPlot.getBirthYear() == birthYear || birthYear == -1) {
								if (curPlot.getDeathYear() == deathYear || deathYear == -1) {
									finalList.add(curPlot);
								}
							}
						}
					}
				}
			}
		}
		else if (record.equalsIgnoreCase("last")) {
			while (!plotList.isEmpty()) {
				Plot curPlot = plotList.remove(0);
				if (curPlot.getMiddleName().equalsIgnoreCase(middleName) || middleName == null) {
					if (curPlot.getLocation().equalsIgnoreCase(location) || location == null) {
						if (curPlot.getBirthYear() == birthYear || birthYear == -1) {
							if (curPlot.getDeathYear() == deathYear || deathYear == -1) {
								finalList.add(curPlot);
							}
						}
					}
				}
			}
		}
		else if (record.equalsIgnoreCase("middle")) {
			while (!plotList.isEmpty()) {
				Plot curPlot = plotList.remove(0);
				if (curPlot.getLocation().equalsIgnoreCase(location) || location == null) {
					if (curPlot.getBirthYear() == birthYear || birthYear == -1) {
						if (curPlot.getDeathYear() == deathYear || deathYear == -1) {
							finalList.add(curPlot);
						}
					}
				}
			}
		}
		else if (record.equalsIgnoreCase("location")) {
			while (!plotList.isEmpty()) {
				Plot curPlot = plotList.remove(0);
				if (curPlot.getBirthYear() == birthYear || birthYear == -1) {
					if (curPlot.getDeathYear() == deathYear || deathYear == -1) {
						finalList.add(curPlot);
					}
				}
			}
		}
		else if (record.equalsIgnoreCase("birth")) {
			while (!plotList.isEmpty()) {
				Plot curPlot = plotList.remove(0);
				if (curPlot.getDeathYear() == deathYear || deathYear == -1) {
					finalList.add(curPlot);
				}
			}
		}
		else {
			finalList = plotList;
			}
		
		return finalList;
	}
}