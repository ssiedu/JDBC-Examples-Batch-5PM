import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DBMDExample {

	public static void main(String[] args) throws Exception {
		
		Connection con=Utility.connect();
		
		DatabaseMetaData dbmd=con.getMetaData();
		
		String dname=dbmd.getDriverName();
		String dversion=dbmd.getDriverVersion();
		String dbName=dbmd.getDatabaseProductName();
		String dbVersion=dbmd.getDatabaseProductVersion();
		
		System.out.println("Driver : "+dname);
		System.out.println("Driver Version : "+dversion);
		System.out.println("Database : "+dbName);
		System.out.println("Database Version : "+dbVersion);
		
		con.close();

	}

}
