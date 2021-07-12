import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmpDeletion {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		String sql = "DELETE FROM emp WHERE sal>=30000";
		Statement stmt = con.createStatement();
		int n = stmt.executeUpdate(sql);
		System.out.println(n + " rows removed...!");
		con.close();

	}

}
