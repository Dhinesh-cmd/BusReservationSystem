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
		String query1 = "Insert into Busbooking  (passenger_name, passenger_num, bus_no, travel_date) values (?,?,?,?)";
		String query2 = "select booking_id from busBooking where passenger_name =? and passenger_num =? and bus_no =? and travel_date =?";
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query1);
		pst.setString(1, booking.passengerName);
		pst.setLong(2, booking.passengerNum);
		pst.setInt(3, booking.busNo);
		
		java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
		pst.setDate(4, sqlDate);
		
		pst.executeUpdate();
		
		Connection conSelect = DBConnection.getConnection();
		PreparedStatement pstSelect = con.prepareStatement(query2);
		pstSelect.setString(1, booking.passengerName);
		pstSelect.setLong(2, booking.passengerNum);
		pstSelect.setInt(3, booking.busNo);
		pstSelect.setDate(4, sqlDate);
		
		ResultSet rs = pstSelect.executeQuery();
		rs.next();
		System.out.println("Your Booking Id is - "+ rs.getInt(1));
	}
	
    public void storeUser(BusBooking booking) throws SQLException {
		String query = "Insert into BookedUser values(?,?,?,?)";
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
	}
}
