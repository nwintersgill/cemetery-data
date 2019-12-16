/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 10/15/2019
 * 
 * Package: TestPlot.java
 * Description: A class to test the editing functions of our Plot class
 */
package com.data;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlot extends TestCase {

	public TestPlot() {
	}
	
	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
 	* Test the ability to add and get the name of an specified plot
 	*/
	@Test
	public void testSetName() {
		String first = "John";
		String last = "Doe";
		String middle = "Joe";
		String spouse = "Jane Doe";
		Plot plot = new Plot();
		
		plot.setFirstName("John");
		assertEquals(plot.getFirstName(), first);
		
		plot.setMiddleName("Joe");
		assertEquals(plot.getMiddleName(), middle);
		
		plot.setLastName("Doe");
		assertEquals(plot.getLastName(), last);
		
		plot.setSpouse("Jane Doe");
		assertEquals(plot.getSpouse(), spouse);
		
		System.out.println("First Name, Middle Name, Last Name, Spouse was successful.");
	}

	/** 
	 * Test the ability to add and get the birth and death years of a 
	 * specified plot
	 */
	@Test
	public void testYears() {
		int birthYear = 2000;
		int deathYear = 2019;
		Plot plot = new Plot();
		
		plot.setBirthYear(2000);
		assertEquals(plot.getBirthYear(), birthYear);
		plot.setDeathYear(2019);
		assertEquals(plot.getDeathYear(), deathYear);
		
		System.out.println("Birth and Death Years were successful.");
	}
	
	/**
	 * Test the ability to change the boolean values: bought and
	 * inUse
	 */
	@Test
	public void testBoughtInUse() {
		Plot plot = new Plot();
		assertEquals(plot.getBought(), false);	//Checking that the default value of bought is false
		
		plot.setInUse(true);
		assertEquals(plot.getInUse(), true);	//Checking that the boolean value can be changed
		
		System.out.println("Bought, InUse was successful.");
	}
	
	/**
	 * Test the ability to change the value of the price of a specified plot
	 */
	@Test
	public void testPrice() {
		int price = 100;
		Plot plot = new Plot();
		
		plot.setPrice(100);
		assertEquals(plot.getPrice(), price);
		
		System.out.println("Set, get Price was successful.");
	}
	
	/**
	 * Test the ability to change and get the location of a specified plot
	 */
	@Test
	public void testLocation() {
		String location = "A-3";
		String notes = "vetran";
		Plot plot = new Plot();
		
		plot.setLocation(location);
		assertEquals(plot.getLocation(), "A-3");
		
		plot.setNotes("vetran");
		assertEquals(plot.getNotes(), notes);
		
		System.out.println("Location, notes were successsful.");
	}
}
