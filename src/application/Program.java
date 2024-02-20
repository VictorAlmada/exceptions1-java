package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			//leitura dos dados da reserva
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			//instanciação e impressão dos dados
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			//leitura da atualização dos dados da reserva
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
			
		} catch (ParseException e) {
			System.out.println("Invalid date format.");
		} catch (DomainException e) {
			System.out.println("Error in reservation : " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		
		sc.close();

	}
}
