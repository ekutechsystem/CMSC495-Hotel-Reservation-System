// Project: Hotel-Reservation-System
// File:  Rooms.java


class Rooms extends Information {

 private static int number = 0;
 private Hotels hotel;
 private Boolean occupied;

 
 public Rooms(String type, int rate, Hotels hotel) {
	 super(type, rate);
	 this.number++;
	 this.hotel = hotel;
	 this.occupied = false;
 }
 
 public void addRes(Reservations reservation) {
	 super.addRes(reservation);
 }
 public int getRate() {
	 return super.getID();
 }
 public int isUnOccupied() {
	 int result = 0;
	 
	 return result;
 }
 public Hotels getHotel(){ return this.hotel; }
 public int getrNum(){ return number; }
 public void setHotel(Hotels hotel){ this.hotel = hotel; } 
 public Boolean getOccupied() { return this.occupied; }
 public void setOccupied(Boolean toWhat){ this.occupied = toWhat; }
}
