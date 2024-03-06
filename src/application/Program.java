package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Reservation date = new Reservation();
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = date.getdateFormat().parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = date.getdateFormat().parse(sc.next());
			
			
				Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
				System.out.println("RESERVATION: "+ reservation);
				
				System.out.println();
				System.out.println("Enter data to update the reservation:");
				System.out.print("Check-in date (DD/MM/YYYY): ");
				checkIn = date.getdateFormat().parse(sc.next());
				System.out.print("Check-out date (DD/MM/YYYY): ");
				checkOut = date.getdateFormat().parse(sc.next());
				
				reservation.updateDate(checkIn, checkOut);
		}catch(ParseException e) {
			System.out.println("Invalid date format!");
		} catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}

		
		sc.close();
	}

}
