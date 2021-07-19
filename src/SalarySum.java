import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SalarySum {

	public static void main(String[] args) throws Exception {
		
		Connection con=Utility.connect();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT SUM(sal), AVG(sal) FROM emp");
		rs.next();
		String sum=rs.getString(1);
		String avg=rs.getString(2);
		System.out.println("Total Salary : "+sum);
		System.out.println("Avg.  Salary : "+avg);
		
		/*
		ResultSet rs=stmt.executeQuery("SELECT sal FROM emp");
		int sum=0;
		while(rs.next()) {
			sum=sum+rs.getInt(1);
		}
		System.out.println("Total Salary : "+sum);
		*/
		con.close();
	}

}
