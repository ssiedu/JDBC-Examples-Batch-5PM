import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataEntry {

	public static void main(String[] args) {
		//this code will enter a new record in emp table
		
		try {
			//step-1 (Driver Loading)
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded Successfully...!");
			
			//step-2 (Connection Establishment)
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
			System.out.println("Connected Successfully...!");
			
			//step-3 (Define A SQL Command)
			//String sql="INSERT INTO emp VALUES(112,'BBB',20000)";
			String sql="INSERT INTO emp VALUES (113,'CCC',30000),(114,'DDD',40000),(115,'EEE',50000)";
			//step-4 (Dispatching SQL Command To DB using Statement Object)
			Statement stmt=con.createStatement();
			int n=stmt.executeUpdate(sql);
			System.out.println(n+" row added...!");
			
			//step-5 (Close The Connection)
			con.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
