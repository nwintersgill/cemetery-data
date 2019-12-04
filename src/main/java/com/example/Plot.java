/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 10/15/2019
 * 
 * Package: Plot.java
 * Description: A class to contain our cemetery plot class
 */

package com.example;

public class Plot {

	String firstName;
	String lastName;
	String spouse;
	String location;
	int birthYear;
	int deathYear;
	int age;
	boolean bought;
	boolean inUse;
	int price;

	public Plot() {
		this.firstName = null;
		this.lastName = null;
		this.spouse = null;
		this.location = null;
		this.birthYear = -1;
		this.deathYear = -1;
		this.age = -1;
		this.bought = false;
		this.inUse = false;
		this.price = -1;
	
}
	public Plot(String firstName, String lastName, String spouse, String location, int birthYear, int deathYear, int age, boolean bought, boolean inUse, int price) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.spouse = spouse;
		this.location = location;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.age = age;
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
	
	public String getSpouse() {
		return spouse;
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public int getDeathYear() {
		return deathYear;
	}
	
	public int getAge() {
		return age;
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
	
	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}

	public void setAge(int age) {
		this.age = age;
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
		String myString = String.format("%-10s %-10s %-20s %-10s %-10s %-10s %-4s %-6s %-6s %-5s", firstName, lastName, spouse, location, Integer.toString(birthYear), Integer.toString(deathYear), Integer.toString(age), Boolean.toString(bought), Boolean.toString(inUse), Integer.toString(price));
		System.out.println(String.format("%-10s %-10s %-20s %-10s %-10s %-10s %-4s %-6s %-6s %-5s", " First", "Last", "Spouse", "Location", "Birth Year", "Death Year", "Age", "Bought", "In Use", "Price"));
		return myString;
	}
	
}

