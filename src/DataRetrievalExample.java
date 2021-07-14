import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataRetrievalExample {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		String sql="SELECT * FROM emp WHERE sal>=25000";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		rs.next();	//move the cursor from before-first (initial) to next row (first)
		String s1=rs.getString(1);	//give you the col-1 of current-row (on which cursor is placed)
		String s2=rs.getString(2);
		String s3=rs.getString(3);
		System.out.println(s1+","+s2+","+s3);
		rs.next();  //move the cursor from first to second row (2nd row is current-row)
		s1=rs.getString(1);
		s2=rs.getString(2);
		s3=rs.getString(3);
		System.out.println(s1+","+s2+","+s3);
		
		
		con.close();
	}

}
