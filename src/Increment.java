import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Increment {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Emp Code : ");
		int code=sc.nextInt();
		System.out.println("Enter Increment Amount : ");
		int amount=sc.nextInt();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		String sql="UPDATE emp SET sal=sal+? WHERE eno=?";	//parameterized sql
		//to send parameterized sql , create an object of PreparedStatement
		PreparedStatement ps=con.prepareStatement(sql);
		//before you execute the sql, you need to set the values of each parameter in sql
		ps.setInt(1,amount);
		ps.setInt(2, code);
		int n=ps.executeUpdate();
		System.out.println(n+" row updated...!");
		con.close();
	}

}
