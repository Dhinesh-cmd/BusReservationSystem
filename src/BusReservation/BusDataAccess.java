package BusReservation;

import java.sql.*;

public class BusDataAccess {
	
	public void displayBusInfo() throws SQLException {
		String query = "Select * from busInfo";
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		System.out.println("Welcome to Developer Bus Zone");
		while(rs.next()) {
			System.out.print("Bus No: "+  rs.getInt(1) + " | ");
			System.out.print("AC: "+ rs.getString(2)+ " | ");
			
			if(rs.getInt(3) < 10) // Just for line adjust
				System.out.print("Bus Capacity: "+ rs.getInt(3)+ "  | ");
			else
				System.out.print("Bus Capacity: "+ rs.getInt(3)+ " | ");
			
			System.out.println();
		}
	}
	
	public int getCapacity(int id) throws SQLException {
		String query = "select capacity from busInfo where id ="+id;
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
