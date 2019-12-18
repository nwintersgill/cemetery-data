package com.data;

import java.io.*;
import java.sql.*;
import java.net.URI;
import java.net.URISyntaxException;

public class AdminInsert {
	
	public static int main(String args[]) {
		String fileName = args[1];
		PQQuery.insertToDB(fileName);
		
		return 0;
	}

}
