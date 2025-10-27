package BusReservation;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BusBookingArea {

	public static void main(String[] args) throws SQLException {
		
		BusDataAccess busDAO = new BusDataAccess();
		
		try                    { busDAO.displayBusInfo(); } // Display Each Bus Infromation
		catch (SQLException e) { e.printStackTrace();     }
		
		// The Booking will continue until user Enter 2 (1 for Book | 2 for Exit)
		int userOpt = 1;
		Scanner sc = new Scanner(System.in);		
		
		while(userOpt == 1) {
			System.out.println();
			System.out.println("Enter 1 to Book");
			System.out.println("Enter 2 to Exit");
			System.out.println("Enter 3 to SomethingElse");
			userOpt = sc.nextInt();
			
			if(userOpt == 1) {
				BusBooking booking = new BusBooking();
				
				if(booking.checkConditions) {
					if(booking.isAvailable(booking)) {
						BookingDAO bookingDAO = new BookingDAO();
						bookingDAO.addBooking(booking);
						bookingDAO.storeUser(booking);
						System.out.println("Your Booking is Confrimed Pick Up Time will Updated Shortly");
					}
					else 
						System.out.println("Sorry.. This Bus is Full on Registered date. Try Another Date or Bus!!");
				}
				
			}
			
			while(userOpt == 3) {
				System.out.println("Enter 4 to Cancel Booking");
				System.out.println("Enter 5 to Get Your Details");
				System.out.println("Enter 9 to Main View");
				userOpt = sc.nextInt();
				if(userOpt == 4) {
					OtherAccess otherAccess = new OtherAccess();
					otherAccess.cancelBooking();
					userOpt = 1;
				}
				else if(userOpt == 5) {
					OtherAccess otherAccess = new OtherAccess();
					otherAccess.getUserInfo();
					userOpt = 1;
				}
			}
		}
		if(userOpt == 2) {
			System.out.println("Thanks for visiting");
		}
		sc.close();
	}

}
