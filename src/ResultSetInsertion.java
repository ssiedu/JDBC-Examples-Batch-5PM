import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetInsertion {
	public static void main(String[] args) throws Exception {

		Connection con=Utility.connect();
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("SELECT * FROM emp");
		while(rs.next()) {
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Wish To Add More Row : (1 - yes) ");
		int ch=sc.nextInt();
		
		if(ch==1) {
			System.out.println("Enter Code : ");
			int code=sc.nextInt();
			System.out.println("Enter Name : ");
			String name=sc.next();
			System.out.println("Enter Sal  : ");
			int sal=sc.nextInt();
			
			//creating a new row
			rs.moveToInsertRow();
			//updatting cols for new row
			rs.updateInt(1, code);
			rs.updateString(2, name);
			rs.updateInt(3,sal);
			//save it to original table
			rs.insertRow();

			System.out.println("Updated Result Set...!");
			rs.beforeFirst();
			while(rs.next()) {
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
		}
		con.close();

		}
}