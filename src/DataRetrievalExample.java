import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataRetrievalExample {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		String sql="SELECT sal,ename,eno FROM emp";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			String s1=rs.getString(1); 		
			String s2=rs.getString(2);	
			String s3=rs.getString(3);
			System.out.println(s1+","+s2+","+s3);
		}
		
		con.close();
	}

}
