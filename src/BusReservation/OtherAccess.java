package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OtherAccess {

	int bookingNo;
	String passengerName;
	int busNo;
	long passengerNum;
	Date date;
	
	public void cancelBooking () throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		System.out.print("Enter Booking Number to Cancel - ");
		bookingNo = sc.nextInt();	
		System.out.println();
		
		String query = "delete from busBooking where booking_id = "+bookingNo;
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		int rowAffected = st.executeUpdate(query);
		
		if(rowAffected == 0) {
			System.out.println("Entered Booking Number is not Valid");
		}
		else {
			System.out.println("Booking Canceled Successfully and Refund will be initiated");
		}
	}
	public void getUserInfo() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		System.out.print("Enter Name of the Passenger - ");
		passengerName = sc.next();
		System.out.println();
		
		System.out.print("Enter Mobile Number - ");
		passengerNum = sc.nextLong();
		System.out.println();
		
		String query = "select * from busBooking where passenger_name =? and passenger_num = ?";
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, passengerName);
		pst.setLong(2, passengerNum);
		ResultSet rs = pst.executeQuery();
		
		boolean recordFound = false;
		
		while(rs.next()) {
			recordFound = true;
			System.out.print("Booking Id - "+ rs.getInt(1) + " | ");
			System.out.print("Booked By - "+ rs.getString(2) + " | ");
			System.out.print("Mobile Number - "+ rs.getLong(3) + " | ");
			System.out.print("Bus No - "+ rs.getInt(4) + " | ");
			System.out.print("Booked on - "+ rs.getDate(5) + " | ");
			System.out.println();
		}
		if (!recordFound) {
	        System.out.println("❌ No booking found for the given name and mobile number.");
	    }
	}
}
