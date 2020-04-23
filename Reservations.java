// Project: Hotel-Reservation-System
// File:  Reservations.java


class Reservations {

	private int startDate;
	private int duration;
	private Hotels hotel;
	private Customers customer;
	private Rooms room;

	
	public Reservations(int startDate, int duration, Customers cus) {
		this.startDate = startDate;
		this.duration = duration;
		this.customer = cus;
	}
	
	public String toString() {
		return "Start date: " + startDate + " duration: " + duration + customer.toString();
	}
		
	public int getStartDate(){ return this.startDate; }
	public int getDuration(){ return this.duration; }
	//public Customers getCustomer() { return this.customer; }
	public Hotels getHotel(){ return this.hotel; }
	public Rooms getRoom(){ return this.room; }

	public void setStartDate( int date ){ this.startDate = date; }
	public void setDuartion(int dur){ this.duration = dur; }
	//public void setCustomer(Customers customer){ this.customer = customer; }
	public void setHotel(Hotels hotel){ this.hotel = hotel; }
	public void setRoom(Rooms room){ this.room = room; }
}
