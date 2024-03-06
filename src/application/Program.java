package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Reservation date = new Reservation();
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = date.getdateFormat().parse(sc.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = date.getdateFormat().parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation! Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("RESERVATION: "+ reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = date.getdateFormat().parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = date.getdateFormat().parse(sc.next());
			
			String error = reservation.updateDate(checkIn, checkOut);
			if(error != null) {
				System.out.println(error);
			}else {
				System.out.println(reservation);
			}
		}
		
		
		
		
		
		
		sc.close();
	}

}
