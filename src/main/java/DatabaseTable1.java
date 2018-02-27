import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import Tests.CustomerModuleTest;

public class DatabaseTable1 {
	
	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	
	public DatabaseTable1 () throws ClassNotFoundException, SQLException {
		
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:hr@//localhost:1521/xe", "hr", "hr");
		st=con.createStatement();
		
	}

	public static void insert(int id) throws SQLException {
		
		
		
		//Connection con=null;
		//Statement st=null;
		//ResultSet rs=null;
		
		//Class.forName("oracle.jdbc.OracleDriver");
		//con=DriverManager.getConnection("jdbc:oracle:thin:hr@//localhost:1521/xe", "hr", "hr");
		//st=con.createStatement();
		
		int update=st.executeUpdate("insert into customer values (id)");
		
		
		
		System.out.println(" row inserted");
		
		
	}
	
	public static void main(String[] args) {
		
		
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:hr@//localhost:1521/xe", "hr", "hr");
			st=con.createStatement();
			
			//WebDriver driver;
			//CustomerModuleTest cust=new CustomerModuleTest ();
			
			
			int id=23456;
			
			insert(id);
			
			//int update=st.executeUpdate("insert into customer values (id)");
			System.out.println(" row inserted");
			
			/*
			rs=st.executeQuery("select * from DollerTree1"); //ORDER BY signUpId desc");
			
			rs.next();
			System.out.println(rs.getString("signupid"));
			System.out.println(rs.getString("emailaddress"));
			System.out.println(rs.getString("fname"));
			System.out.println(rs.getString("lname"));
			
			
			/*int update=st.executeUpdate("insert into verifyLogin values ('aaaaa','1111')");
			System.out.println(update+ "Row Inserted");
			rs=st.executeQuery("select * from verifyLogin ORDER By username");
			rs.next();
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			
			*/
			//rs=st.executeUpdate("insert into verifyLogin values('aaaa','1234,)");
			/*
			rs=st.executeQuery("select * from verifyLogin");
			rs.next();
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			*/
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally
		{
			if (con!=null)
			{
				con=null;
				System.out.println("connection close");
			}
		}
		
		
		
		
		
		
		
		

	}


	}


