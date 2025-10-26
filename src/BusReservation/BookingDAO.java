package BusReservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BookingDAO {
	
	public int getBookedCount(int busNo, java.util.Date date) throws SQLException {
		
		String query = "SELECT COUNT(passenger_name) FROM Busbooking WHERE bus_no = ? AND travel_date = ?";
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, busNo);
		
		// convert java.util.date - java.sql.date
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pst.setDate(2, sqlDate);
		
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public void addBooking(BusBooking booking) throws SQLException{
		String query = "Insert into Busbooking values(?,?,?)";
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		
		java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
		pst.setDate(3, sqlDate);
		
		pst.executeUpdate();
	}
}
