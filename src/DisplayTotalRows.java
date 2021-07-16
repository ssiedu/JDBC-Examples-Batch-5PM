import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayTotalRows {
public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		String sql="SELECT * FROM emp";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		//rs.next();
		String s1=rs.getString(1);
		System.out.println(s1);
		//wish to display total rows in ResultSet
		//rs.last();	//move the cursor on last-row
		//rs.afterLast();
		//int n=rs.getRow();
		//System.out.println(n);
		
		con.close();
	}
}
