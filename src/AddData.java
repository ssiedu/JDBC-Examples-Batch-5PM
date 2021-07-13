import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddData {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Eno	 : ");
		int code=sc.nextInt();
		System.out.println("Enter Ename  : ");
		String name=sc.next();
		System.out.println("Enter Sal    : ");
		int sal=sc.nextInt();
		
		String sql="INSERT INTO emp VALUES(?,?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, code);
		ps.setString(2, name);
		ps.setInt(3, sal);
		int n=ps.executeUpdate();
		con.close();
		System.out.println(n+" row added...!");
		
	}

}
