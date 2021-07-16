import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReadAbsoluteRow {

public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		String sql="SELECT * FROM emp";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(true) {
			System.out.println("Which row you wish to see (0 for exit) : ");
			int n=sc.nextInt();
			if(n==0)break;
			
			boolean found=rs.absolute(n);
			if(found) {
				int num=rs.getRow();
				System.out.println("Row No. : "+num);
				String s1=rs.getString(1); String s2=rs.getString(2); String s3=rs.getString(3);
				System.out.println(s1+","+s2+","+s3);
			}else {
				System.out.println("Invalid Row no..");
			}
		}
		
		con.close();
	}

}
