/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 10/25/2019
 * 
 * Package: PQQuery.java
 * Description: Functions to interact with the database including connect to the database, 
 * 				readLine, insert to database.
 */

package com.data;

import java.io.*;
import java.sql.*;

public class PQQuery {
	 public static void main(String argv[])    {
		 
			connectDB();
			/*		Connection db = connectDB(); */

			//	createDB(db, "xmJavaTestTbl");  // create called once!
			//	insertToDB(db, "xmJavaTestTbl");
			/* testQuery(db, "xmJavaTestTbl"); */
	    }

	    public static void loadDriver()   {

			try {
				Class.forName("org.postgresql.Driver");
				//Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded okay...");
			}  catch (ClassNotFoundException e) {
				System.err.println("Driver class not found, exiting ...");
				System.exit(1);
			}  catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(1);
			}
	    }

	    public static String readLine()    {

			String localStr = "";
			try  {
				BufferedReader in = 
					new BufferedReader(new InputStreamReader (System.in) );
				localStr = in.readLine();
			}  catch (IOException e)  {
				System.out.println("IO exception, exiting ...");
				System.exit(1);
			}
			return localStr;
	    }

	    public static Connection connectDB()   {

			// If mysql database is installed on a local host, do this
			// Otherwise see the rest of the function
			/*
			c = DriverManager
				.getConnection("jdbc:mysql://localhost:5432/testdb",
							   "mysql", "123");
			*/

			//String user, pass;
			String url = System.getenv("DATABASE_URL");

			//System.out.print("enter user name and password in one line, separated by a space : ");
			//String info = readLine();

			//int split = info.indexOf(' ');
			//user = info.substring(0, split);
			//pass = info.substring(split+1);
			Connection db = null;
			try  {
				//	    System.out.println(url+" "+user+" "+pass);
				System.out.println("URL: " + url);
				db = DriverManager.getConnection(url);
			}  catch (SQLException e) {
				System.out.println("SQLException when connecting, exiting ...");
				System.exit(1);
			}
			return db;
	    }

	/*
	 * public static void createDB(Connection db, String tblName) {
	 * 
	 * try { Statement s = db.createStatement(); s.executeUpdate("create table " +
	 * tblName + "(name char(10), age integer, salary real)");
	 * System.out.println("create table successfully ..."); } catch (SQLException e)
	 * { System.out.println("create table failed, exiting ..."); System.exit(1); } }
	 */

	    public static void insertToDB(Connection db, String fileName, String tblName)  {
	    	
	    	String curString = "";
			try  {
				//creates an instance of the database to insert
				Statement s = db.createStatement();
				
				//open, read the file, and insert into database 
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				while (reader.readLine() != null) {
					curString = reader.readLine();
					s.executeUpdate("INSERT INTO " + tblName + "VALUES " + curString);
					reader.close();
					
				}
			}   
			
			//Catch for when initializing the reader
			catch (FileNotFoundException e)  {
				System.out.println("specified file was not found, exiting ...");
				System.exit(1);
			}
			
			//Catch for readLine()
			catch (IOException e) {
				System.out.println("There was an issue with the Input, exiting.");
				System.exit(1);
			}
			
			//Catch for creating a statement in the database
			catch (SQLException e) {
				System.out.println("The was an issue with the database, exiting");
				System.exit(1);
				
			}
	    
	    }


	    public static void testQuery(Connection db, String tblName)   {

			try  {
				Statement s = db.createStatement();

				ResultSet rs = s.executeQuery("SELECT * FROM " + tblName);

				while (rs.next())  {
					String firstName = rs.getString(1);  // first field is the first name
					String middleName = rs.getString(2);  // second field is the middle name
					String lastName = rs.getString(3);  // third field is last name

					System.out.println("Full name: " + firstName + " " + middleName + " " + lastName);
				}
			}  catch (SQLException e)  {
				System.out.println("query failed, exiting ...");
				System.exit(1);
			}
	    }
	}
