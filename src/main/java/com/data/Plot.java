/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 10/15/2019
 * 
 * Package: Plot.java
 * Description: A class to contain our cemetery plot class
 */

package com.data;

import java.util.Date;

public class Plot {

	String firstName;
	String lastName;
	String middleName;
	String spouse;
	String plotLocation;
	String notes;		//Veteran, historical significance, etc
	int birthYear;
	int deathYear;
	Date datePurchased;
	boolean bought;
	boolean inUse;
	int price;
	

	public Plot() {
		this.firstName = null;
		this.lastName = null;
		this.middleName = null;
		this.spouse = null;
		this.plotLocation = null;
		this.notes = null;
		this.birthYear = -1;
		this.deathYear = -1;
		this.datePurchased = null;
		this.bought = false;
		this.inUse = false;
		this.price = -1;
	
}
	@SuppressWarnings("deprecation")
	public Plot(String firstName, String lastName, String middleName, String spouse, String plotLocation, String notes, int birthYear, int deathYear, String purchaseDate, boolean bought, boolean inUse, int price) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.spouse = spouse;
		this.plotLocation = plotLocation;
		this.notes = notes;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.datePurchased = new Date(purchaseDate);
		this.bought = bought;
		this.inUse = inUse;
		this.price = price;
	}
	
	public static void main(String[] args) {
	}
	
	
	//Getters for all attributes of the plot class
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getSpouse() {
		return spouse;
	}
	
	public String getLocation() {
		return plotLocation;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public int getDeathYear() {
		return deathYear;
	}
	
	public Date getDatePurchased() {
		return datePurchased;
	}
	
	public boolean getBought() {
		return bought;
	}
	
	public boolean getInUse() {
		return inUse;
	}
	
	public int getPrice() {
		return price;
	}
	
	//setters for all attributes of the plot class
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}
	
	public void setLocation(String location) {
		this.plotLocation = location;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}
	
	@SuppressWarnings("deprecation")
	public void setDatePurchased(String purchaseDate) {
		this.datePurchased = new Date(purchaseDate);
	}
	
	public void setBought(boolean bought) {
		this.bought = bought;
	}
	
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		String myString = String.format("%-10s %-10s %-10s %-20s %-8s %-15s %-4s %-4s %-20s %-6s %-6s %-5s", this.firstName, this.lastName, this.middleName, this.spouse, this.plotLocation, this.notes, Integer.toString(this.birthYear), Integer.toString(this.deathYear), this.datePurchased, Boolean.toString(this.bought), Boolean.toString(this.inUse), Integer.toString(this.price));
		System.out.println(String.format("%-10s %-10s %-10s %-20s %-8s %-15s %-4s %-4s %-20s %-6s %-6s %-5s", "First Name", "Last Name", "Mid Name", "Spouse Name", "Location", "Notes", "Birth Year", "Death Year", "Date Bought", "Bought", "In Use", "Price"));
		return myString;
	}
	
}

