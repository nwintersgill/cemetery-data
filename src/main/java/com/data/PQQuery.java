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
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp2.BasicDataSource;


@Configuration
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

			Connection db = null;
			
			try  {
				BasicDataSource source = dataSource();
				//	    System.out.println(url+" "+user+" "+pass);
				//		System.out.println("URL: " + url);
				db = source.getConnection();
			}  catch (SQLException e) {
				System.out.println("SQLException when connecting, exiting ...");
				System.exit(1);
			} catch (URISyntaxException e) {
				System.out.println("URISyntaxException when connecting, exiting ...");
				System.exit(1);
			}
			return db;
	    }

	    @Bean
    	public static BasicDataSource dataSource() throws URISyntaxException {
    		// If mysql database is installed on a local host, do this
			// Otherwise see the rest of the function
			/*
			c = DriverManager
				.getConnection("jdbc:mysql://localhost:5432/testdb",
							   "mysql", "123");
			*/

        	URI dbUri = new URI(System.getenv("DATABASE_URL"));

        	String username = dbUri.getUserInfo().split(":")[0];
        	String password = dbUri.getUserInfo().split(":")[1];
        	String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        	BasicDataSource basicDataSource = new BasicDataSource();
        	basicDataSource.setUrl(dbUrl);
        	basicDataSource.setUsername(username);
        	basicDataSource.setPassword(password);

        	return basicDataSource;
    	}

	/*
	 * public static void createDB(Connection db, String tblName) {
	 * 
	 * try { Statement s = db.createStatement(); s.executeUpdate("create table " +
	 * tblName + "(name char(10), age integer, salary real)");
	 * System.out.println("create table successfully ..."); } catch (SQLException e)
	 * { System.out.println("create table failed, exiting ..."); System.exit(1); } }
	 */

	    public static void insertToDB(String fileName)  {
	    	Connection db = connectDB();
	    	
	    	PreparedStatement s;
	    	ResultSet results;
			try  {
				//creates an instance of the database to insert
				s = db.prepareStatement("INSERT INTO plot VALUES ?;");
				
				//open, read the file, and insert into database 
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				reader.readLine();
				while (reader.readLine() != null) {
					String curString = "";
					curString = reader.readLine();
					s.setString(1, curString);
					s.executeUpdate();
				}
				reader.close();
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
