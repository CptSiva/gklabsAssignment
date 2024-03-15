package com.loginPageAssignment;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetrieveDAO
{
public ArrayList<DetailsBean> al=new ArrayList<DetailsBean>();
	
	public ArrayList<DetailsBean> retrieve()
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from users_data");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				DetailsBean pb=new DetailsBean();
				pb.setId(rs.getInt("id")); // Retrieve and set ID
	            pb.setName(rs.getString("name"));
	            pb.setEmail(rs.getString("email"));
	            pb.setAge(rs.getInt("age"));
	            pb.setDate(rs.getDate("dob"));
	            al.add(pb);
				/*
				 * pb.setId(rs.getInt(1)); pb.setName(rs.getString(2));
				 * pb.setEmail(rs.getString(3)); pb.setAge(rs.getInt(4));
				 */
				try {
				    java.sql.Date sqlDate = rs.getDate(5); 
				    if (sqlDate != null) {
				        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
				        pb.setDate(utilDate);
				    } else {
				        // Handle null value if necessary
				    }
				} catch (SQLException e) {
				    // Handle SQLException if necessary
				    e.printStackTrace();
				}

				al.add(pb);
			}//end of while loop
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
		
	}

}
