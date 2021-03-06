import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowTable {
	
	private final static String Driver="org.h2.Driver";
	private final static String DUrl="jdbc:h2:tcp://localhost/~/test3";
	private final static String DUname="root";
	private final static String DPwd="";
	

	public static void main(String[] args) {
	
		try
		{
			Class.forName(Driver);
			Connection conn=DriverManager.getConnection(DUrl, DUname, DPwd);
			Statement stmt=conn.createStatement();
			
			String query="select * from product";
			
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.print(rs.getString(1)+" :: ");
				System.out.print(rs.getString(2)+" :: ");
				System.out.println(rs.getInt(3)+" :: ");
			}
			
			stmt.close();
			conn.close();
		}
		catch (Exception e) 
		{
			System.out.println("Exception Occured"+e);
		}
	}

}
