/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 10/15/2019
 * 
 * Package: TestPlot.java
 * Description: A class to test the editing functions of our Plot class
 */
package plot;

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
		System.out.print("First Name, Last Name, Spouse\n");
		String first = "John";
		String last = "Doe";
		String spouse = "Jane Doe";
		Plot plot = new Plot();
		
		plot.setFirstName("John");
		assertEquals(plot.getFirstName(), first);
		
		plot.setLastName("Doe");
		assertEquals(plot.getLastName(), last);
		
		plot.setSpouse("Jane Doe");
		assertEquals(plot.getSpouse(), spouse);
	}

	/** 
	 * Test the ability to add and get the birth and death years of a 
	 * specified plot
	 */
	@Test
	public void testAge() {
		System.out.print("Birth, Death Years and Age\n");
		int birthYear = 2000;
		int deathYear = 2019;
		int age = 19;
		Plot plot = new Plot();
		
		plot.setBirthYear(2000);
		assertEquals(plot.getBirthYear(), birthYear);
		plot.setDeathYear(2019);
		assertEquals(plot.getDeathYear(), deathYear);
		plot.setAge(19);
		assertEquals(plot.getAge(), age);
	}
	
	/**
	 * Test the ability to change the boolean values: bought and
	 * inUse
	 */
	@Test
	public void testBoughtInUse() {
		System.out.print("Bought, InUse\n");
		Plot plot = new Plot();
		assertEquals(plot.getBought(), false);	//Checking that the default value of bought is false
		
		plot.setInUse(true);
		assertEquals(plot.getInUse(), true);	//Checking that the boolean value can be changed
	}
	
	/**
	 * Test the ability to change the value of the price of a specified plot
	 */
	@Test
	public void testPrice() {
		System.out.print("Set, get Price\n");
		int price = 100;
		Plot plot = new Plot();
		
		plot.setPrice(100);
		assertEquals(plot.getPrice(), price);
	}
}
