package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public SimpleDateFormat getdateFormat() {
		return dateFormat;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDate(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(!checkOut.after(checkIn)) {
			return "Error in reservation! Check-out date must be after check-in date";
			
		}if (checkIn.before(now) || checkOut.before(now)){
			return "Error in reservation! Reservation dates for upgrade must be future dates";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
		
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ dateFormat.format(checkIn)
				+ ", check-out: "
				+ dateFormat.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
		
	}
	
}
