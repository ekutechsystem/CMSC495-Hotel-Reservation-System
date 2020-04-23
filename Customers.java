// Project: Hotel-Reservation-System
// File:  Customers.java

public class Customers extends Information {

 //private String name;
 private String rPref;
 private static int count = 0;
 
 public Customers(String name, String rPref) {
	 super(name, count++ );
	 this.rPref = rPref;
 }

 public String toString() {
	 return super.toString() + " " + "Prefered room: " + getrPref();
 }
 public String getrPref(){ return this.rPref; }
 public void setrPref( String rPref){ this.rPref = rPref; }
}
