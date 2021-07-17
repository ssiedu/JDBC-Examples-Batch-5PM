import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetUpdation {

	public static void main(String[] args) throws Exception {

		Connection con=Utility.connect();
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("SELECT * FROM emp");
		while(rs.next()) {
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Row No. : ");
		int rn=sc.nextInt();
		System.out.println("New Sal : ");
		int amt=sc.nextInt();
		
		//moving cursor to the row to be changed
		rs.absolute(rn);
		//changing sal (in rs)
		rs.updateInt("sal", amt);
		//save changes to table
		rs.updateRow();
		System.out.println("Salary Modified...!");
		System.out.println("Updated Result Set...!");
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		
		con.close();
	}

}
