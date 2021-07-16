import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReverseOrderDisplay {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		String sql = "SELECT * FROM emp";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}//loop will terminate on afterLast
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getString(3));
		}
		
		/*
		//rs.last();
		rs.afterLast();
		while (rs.previous()) {
			String s1 = rs.getString(1);
			String s2 = rs.getString(2);
			String s3 = rs.getString(3);
			System.out.println(s1 + "," + s2 + "," + s3);
		}
		*/
		con.close();
	}
}
