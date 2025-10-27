package BusReservation;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BusBooking {
	String passengerName;
	int busNo;
	long passengerNum;
	Date date;
	int seat;
	boolean checkConditions = true;
	int seatFilled = 1;
	
	BusBooking() {
		seat = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		System.out.print("Enter Bus No - ");
		busNo = sc.nextInt();	
		System.out.println();
		
		System.out.print("Enter Name of the Passenger - ");
		passengerName = sc.next();
		System.out.println();
		
		System.out.print("Enter Mobile Number - ");
		passengerNum = sc.nextLong();
		System.out.println();
		
		
		System.out.print("Enter Journey Date dd-mm-yyyy - ");
		String dateInput = sc.next();
		
		
		// Convert String to Date Object By SimpleDateFormat(date format) Class
		// (In that class we have parse Method That take a argument String and Convert to Date object
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try { date = dateFormat.parse(dateInput); }
		catch (ParseException e) { e.printStackTrace(); }
		System.out.println();
		
		Date currentDate = new Date(); // today's date
		Date enteredDate = date; // or any input date

		while (!enteredDate.after(currentDate)) {
			System.out.println("Invalid date — travel date must be in the future.");
			checkConditions = false;
			System.out.print("Enter Journey Date dd-mm-yyyy | Or Enter 9 to Main View - ");
			dateInput = sc.next();
			if(dateInput.equals("9"))
				break;
			
			try { date = dateFormat.parse(dateInput); }
			catch (ParseException e) { e.printStackTrace(); }
			System.out.println();
			enteredDate = date;
		} 
		
		
		
//		System.out.print("How many Seats Need to Book - ");
//		seat = sc.nextInt();
//		System.out.println();
	}
	
	public boolean isAvailable(BusBooking booking) throws SQLException {
		BusDataAccess busDAO = new BusDataAccess();
		BookingDAO bookingDAO = new BookingDAO();
		
		int capacity = busDAO.getCapacity(busNo);
		int booked = bookingDAO.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
	
	
	
	
}
