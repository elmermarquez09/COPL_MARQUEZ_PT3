package copl_ex1;
import  java.sql.Connection;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class JobDetails {

	public static void main(String[] args) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@//localhost:1521/xepdb1");
		Connection conn = ods.getConnection();
		Statement stmt = conn.createStatement();
		Statement stmt1 = conn.createStatement();
		Statement stmt2 = conn.createStatement();

		// Execute a statement - DO THIS WITH AT LEAST 3 TABLES - provide screenshot
		ResultSet rset = stmt.executeQuery("Select DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID from departments");
		ResultSet rset1 = stmt1.executeQuery("Select COUNTRY_ID, COUNTRY_NAME, REGION_ID from countries");
		ResultSet rset2 = stmt2.executeQuery("Select REGION_ID, REGION_NAME from regions");
		//  Iterate  through  the  result  and  print  the  employee  names  and  ID
		System.out.println("Department ID" + "\t" + "Department Name" + "\t" + "Manager ID" + "\t" + "Location ID");
		System.out.println();
		while (rset.next()) {
			System.out.println(rset.getString(1)
					  + "\t" + rset.getString(2)
					  + "\t" + rset.getString(3)
					  + "\t" + rset.getString(4));
		}//end while
		System.out.println();
		System.out.println("Country ID" + "\t" + "Country Name" + "\t" + "Region ID");
		System.out.println();
		while (rset1.next()) {
			System.out.println(rset1.getString(1)
					  + "\t" + rset1.getString(2)
					  + "\t" + rset1.getString(3));
		}
		System.out.println();
		System.out.println("Region ID" + "\t" + "Region Name");
		System.out.println();
		while (rset2.next()) {
			System.out.println(rset2.getString(1)
					  + "\t" + rset2.getString(2));
					 
		}//end while//end while
		//close the resources
		rset.close();
		stmt.close();
		rset1.close();
		stmt1.close();
		rset2.close();
		stmt2.close();
	}//end method main
}//end class JobDetails