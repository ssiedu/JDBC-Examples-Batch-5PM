import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RSMDExample {

	public static void main(String[] args) throws Exception {
		
		Connection con=Utility.connect();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM emp");
		ResultSetMetaData rsmd=rs.getMetaData();
		int n=rsmd.getColumnCount();
		System.out.println("_____________________________________________________");
		for(int i=1; i<=n; i++) {
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		System.out.println();
		System.out.println("_____________________________________________________");
		while(rs.next()) {
			for(int i=1; i<=n; i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		System.out.println("_____________________________________________________");
		con.close();
	}

}
