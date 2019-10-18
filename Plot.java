/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 10/15/2019
 * 
 * Package: Plot.java
 * Description: A class to contain our cemetery plot class
 */
package plot;

public class Plot {

	String name;
	int birthYear;
	int deathYear;
	boolean bought;
	boolean inUse;
	int price;

	public Plot() {
		this.name = null;
		this.birthYear = -1;
		this.deathYear = -1;
		this.bought = false;
		this.inUse = false;
		this.price = -1;
	
}
	public Plot(String name, int birthYear, int deathYear, boolean bought, boolean inUse, int price) {
		this.name = name;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.bought = bought;
		this.inUse = inUse;
		this.price = price;
	}
	
	public static void main(String[] args) {
	}
	
	
	//Getters for all attributes of the plot class
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public int getDeathYear() {
		return deathYear;
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
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
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
}

