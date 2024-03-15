package com.loginPageAssignment;
import java.sql.*;
public class RegistrationDAO
{
	private static int k=0;
	
	public int insert(DetailsBean db)
	{
		try
		{
			Connection con=DBConnection.getCon();
					PreparedStatement ps=con.prepareStatement("insert into users_data values( users_data_seq.NEXTVAL,?,?,?,?)");
					//ps.setInt(1, db.getId());
					ps.setString(1, db.getName());
					ps.setString(2, db.getEmail());
					ps.setInt(3,db.getAge());
					 ps.setDate(4, new java.sql.Date(db.getDate().getTime()));
					 k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
			
		
	

}
