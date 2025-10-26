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
			System.out.print("Enter 1 to Book or Enter 2 to Exit - ");
			userOpt = sc.nextInt();
			
			if(userOpt == 1) {
				BusBooking booking = new BusBooking();
				
				if(booking.checkConditions) {
					if(booking.isAvailable(booking)) {
						BookingDAO bookingDAO = new BookingDAO();
						bookingDAO.addBooking(booking);
						System.out.println("Your Booking is Confrimed Pick Up Time will Updated Shortly");
					}
					else 
						System.out.println("Sorry.. This Bus is Full on Registered date. Try Another Date or Bus!!");
				}
				
			}
		}
		if(userOpt == 2) {
			System.out.println("Thanks for visiting");
		}
		sc.close();
	}

}
