import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SalaryIncrement {

	public static void main(String[] args) throws Exception {
		//step-1 (Driver Loading)
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded...!");
		//step-2 (Connection Establishment)
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		System.out.println("Connected...!");
		//step-3 (Define SQL For Updation)
		String sql="UPDATE emp SET sal=sal+1000 WHERE sal>25000";
		//step-4 (Dispatch SQL To DB For Execution)(Using Statement/PreparedStatement Object)
		Statement stmt=con.createStatement();
		int n=stmt.executeUpdate(sql);
		System.out.println(n+" rows modified...!");
		//step-5 (Close The Connection)
		con.close();
		
	}

}
