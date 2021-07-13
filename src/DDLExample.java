import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DDLExample {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		//String sql = "CREATE TABLE IF NOT EXISTS dummy(col1 char, col2 char)";
		String sql="DROP TABLE dummy";
		Statement stmt = con.createStatement();
		
		int n = stmt.executeUpdate(sql);
		//System.out.println(n+" TABLE CREATED...!");
		System.out.println("TABLE DROPPED...!");
		con.close();

	}
}
