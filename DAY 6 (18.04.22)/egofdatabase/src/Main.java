
import java.sql.*;

import java.util.*;

// Main class
class Main{

	// Main driver method
	public static void main(String a[])
	{

		String url = "jdbc:mysql://localhost:3306/dataset1";
		String user = "root";
		String pass = "thilak";

		// Entering the data
		Scanner k = new Scanner(System.in);

		System.out.println("enter name");
		String name = k.next();

		System.out.println("enter roll no");
		int roll = k.nextInt();

		System.out.println("enter class");
		String cls = k.next();

		// Inserting data using SQL query
		String sql = "insert into egdb values('" + name
					+ "'," + roll + ",'" + cls + "')";

		// Connection class object
		Connection con = null;

		// Try block to check for exceptions
		try {

			// Reference to connection interface
			con = DriverManager.getConnection(url,user,pass);

			// Creating a statement
			Statement st = con.createStatement();

			// Executing query
			int m = st.executeUpdate(sql);
			if (m == 1)
				System.out.println(
					"inserted successfully : " + sql);
			else
				System.out.println("insertion failed");

			// Closing the connections
			con.close();
		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	}
}
