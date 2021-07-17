import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetDeletion {
	public static void main(String[] args) throws Exception {

		Connection con=Utility.connect();
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("SELECT * FROM emp");
		while(rs.next()) {
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Wish To Delete A  Row : (1 - yes) ");
		int ch=sc.nextInt();
		
		if(ch==1) {
			System.out.println("Enter Row No : ");
			int n=sc.nextInt();
			//cursor move
			rs.absolute(n);
			//delete row
			rs.deleteRow();
			System.out.println("Updated Result Set...!");
			rs.beforeFirst();
			while(rs.next()) {
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
		}
		con.close();

		}
}
