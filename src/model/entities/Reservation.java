package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	//atributos
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//contrutor com argumentos
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	//getter e setter de roomNumber
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	//getter de checkIn
	public Date getCheckIn() {
		return checkIn;
	}
	//getter de checkOut
	public Date getCheckOut() {
		return checkOut;
	}
	
	//métodos
	public long duration() {
		//pegando a diferença das datas em milissegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		//transformar essa diferença em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);	
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	//toString
	@Override
	public String toString() {
		return "### Reservation ###\nRoom " + getRoomNumber()
		+ "\nCheck-in: " + sdf.format(checkIn)
		+ "\nCheck-out: " + sdf.format(checkOut)
		+ "\nTotal: " + duration() + " nights";
	}
}
