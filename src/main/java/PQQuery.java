/**
 * Name: Team Reaper - Nina Benson, Nathan Wintersgill, Joe Yu, Lucas Morgan
 * Date: 10/25/2019
 * 
 * Package: DataSource.java
 * Description:
 */
package plot;

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

			String user, pass;
			String url = System.getenv("JDBC_DATABASE_URL");

			System.out.print("enter user name and password in one line, separated by a space : ");
			String info = readLine();

			int split = info.indexOf(' ');
			user = info.substring(0, split);
			pass = info.substring(split+1);
			try  {
				//	    System.out.println(url+" "+user+" "+pass);
				System.out.println(url+"  user_name pass_word");
				db = DriverManager.getConnection(url, user, pass);
			}  catch (SQLException e) {
				System.out.println("SQLException, exiting ...");
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
					s.executeUpdate("insert into " + tblName + "values " + curString);
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

				ResultSet rs = s.executeQuery("select * from " + tblName);

				while (rs.next())  {
					String name = rs.getString(1);  // first field is name
					int    age  = rs.getInt(2);     // second field is age
					double salary = rs.getDouble(3); // third field is salary

					System.out.println(name + " " + age + " " + salary);
				}
			}  catch (SQLException e)  {
				System.out.println("query failed, exiting ...");
				System.exit(1);
			}
	    }
	}
