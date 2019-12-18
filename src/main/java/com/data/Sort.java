/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 11/23/2019
 * 
 * Package: Sort.java
 * Description: A class to contain the sort function of the plot table within our database
 */

package com.data;

import java.util.ArrayList;

public class Sort {
	
	public static void SortFirst(ArrayList<Plot> plots) {
		int size = plots.size();
		for (int i = 0; i < size -1; i++) {
			for (int j = 0; j < size-i-1; j++) {
				Plot iPlot = plots.get(j);
				String iName = iPlot.getFirstName();
				Plot jPlot = plots.get(j + 1);
				String jName = jPlot.getFirstName();
				
				if (iName.compareTo(jName) > 0) {
				Plot temp = iPlot;
				plots.set(j, jPlot);
				plots.set(j+1, temp);
				}
			}
		}
	}
	
	public static void SortLast(ArrayList<Plot> plots) {
		int size = plots.size();
		for (int i = 0; i < size -1; i++) {
			for (int j = 0; j < size-i-1; j++) {
				Plot iPlot = plots.get(j);
				String iName = iPlot.getLastName();
				Plot jPlot = plots.get(j + 1);
				String jName = jPlot.getLastName();
				
				if (iName.compareTo(jName) > 0) {
				Plot temp = iPlot;
				plots.set(j, jPlot);
				plots.set(j+1, temp);
				}
			}
		}
	}
	
	public static void SortBirthYear(ArrayList<Plot> plots) {
		int size = plots.size();
		for (int i = 0; i < size -1; i++) {
			for (int j = 0; j < size-i-1; j++) {
				Plot iPlot = plots.get(j);
				int iYear = iPlot.getBirthYear();
				Plot jPlot = plots.get(j + 1);
				int jYear = jPlot.getBirthYear();
				
				if (iYear > jYear) {
				Plot temp = iPlot;
				plots.set(j, jPlot);
				plots.set(j+1, temp);
				}
			}
		}
	}
	
	public static void SortDeathYear(ArrayList<Plot> plots) {
		int size = plots.size();
		for (int i = 0; i < size -1; i++) {
			for (int j = 0; j < size-i-1; j++) {
				Plot iPlot = plots.get(j);
				int iYear = iPlot.getDeathYear();
				Plot jPlot = plots.get(j + 1);
				int jYear = jPlot.getDeathYear();
				
				if (iYear > jYear) {
				Plot temp = iPlot;
				plots.set(j, jPlot);
				plots.set(j+1, temp);
				}
			}
		}
	}

}
