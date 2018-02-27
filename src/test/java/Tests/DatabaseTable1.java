package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTable1 {


	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	
	public DatabaseTable1 () throws ClassNotFoundException, SQLException {
		
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:hr@//localhost:1521/xe", "hr", "hr");
		Statement st=con.createStatement();
		int update=st.executeUpdate("insert into customer values (id)");
		System.out.println(update+" row inserted");
	}

	public static void insert(int id) throws SQLException, ClassNotFoundException {
		
		st=con.createStatement();
		int update=st.executeUpdate("insert into customer values (id)");
		System.out.println(update+" row inserted");
		
		
	}





}
