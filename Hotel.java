// Project: Hotel-Reservation-System
// File:  Hotel.java

import java.io.*;
import java.util.*;

public class Hotel {
	
	static String type;
	static String hotelName, cusName, lName, fName, rPrefered;
	static int ID, rate, rDate, rDuration, rID, cID, cDate, op;
	static Database db = new Database();
	
	public static void main(String[] args) {
		if ( args.length == 0 ) {
			 System.out.println("Usage: java A1 <input file>");
			 System.exit(0);
    		
		} else {
			processFile(args[0]);
			db.hotelprint();
			processFile(args[1]);
			System.out.println("\n************* Customer's list in database ***************\n");
			db.cusPrint();
			//db.resPrint();
		}
		System.out.println("Program ended successfully.");		
	}
	
	public static void processFile(String arg) {
		Customers cus = null;
		try {
			
			Scanner input = new Scanner(new File(arg));
			String line;
			
			while( input.hasNextLine() ) {
				line = input.nextLine();
				if(line.length() > 0 ) {
					if(arg.equals("Hotels.txt")) {
						processLine(line);
					} else {
						op = processbLine(line);
						
						if(op == 1 ) {
							line = input.nextLine();
							op = processbLine(line);
							if(op == 0 ) {
								cus = db.addCustomer(lName,fName, rPrefered);
								db.addReservation(rDate, rDuration, rID, cus);
							} 
						}else {
							if( op == -1 ) {
								line = input.nextLine();
							}
						}	
					}
				}
			}
			input.close();
			
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage() );
			ioe.printStackTrace();
		}
	}
	
	public static void processLine(String line) {
		
		String tokens[];
		char c = line.charAt(0);
		
		if (Character.isDigit(c) ) {
			ID = Integer.parseInt(line);
		} else {
			if( Character.isLetter(c)) {
				tokens = line.split(" ");

				if( !tokens[0].equals("double") && !tokens[0].equals("king") && !tokens[0].equals("suite") ) {
					hotelName = tokens[0] + " " + tokens[1];
					db.addHotel(hotelName, ID);
					
				} else {
					type = tokens[0];
					rate = Integer.parseInt(tokens[1]);
					db.addRoom(hotelName, type, rate);
					} // inner else 
				} //inner if
			} // outer else
		
		} // end processLine
	
	public static int processbLine(String line) {
		String tokens[];
		int operation = 1; // 1 for reserve, -1 for cancel, 0 for customer data
		tokens = line.split("\\s+|,|:");
		
		if(tokens[0].equals("RESERVE")) {
			
			if(tokens[1].equals("HOTEL")) {
				rID = Integer.parseInt(tokens[2]);
			} else {
				rDate = Integer.parseInt(tokens[2]);
			}
			
			if(tokens[3].equals("START")) {
				rDate = Integer.parseInt(tokens[4]);
			} else if(tokens[3].equals("DURATION")) {
				rDuration = Integer.parseInt(tokens[4]);
			} else {
				rID = Integer.parseInt(tokens[4]);
			}
			
			if(tokens[5].equals("DURATION")) {
				rDuration = Integer.parseInt(tokens[6]);
			} else if(tokens[5].equals("HOTEL")) {
				rID = Integer.parseInt(tokens[6]);
			} else {
				rDate = Integer.parseInt(tokens[6]);
			}
			
		} else if(tokens[0].equals("CANCEL")) {
			operation = -1;
			if(tokens[1].equals("HOTEL")) {
				cID = Integer.parseInt(tokens[2]);
			} else {
				cDate = Integer.parseInt(tokens[2]);
			}
			
			if(tokens[2].equals("START")) {
				cDate = Integer.parseInt(tokens[3]);
			} else {
				cID = Integer.parseInt(tokens[2]);
			}
			
		} else {
			lName = tokens[0];
			fName = tokens[1];
			operation = 0;
			if(tokens.length == 3) {
				char ch = tokens[2].charAt(0);
				if(Character.isDigit(ch)) {
					rPrefered = tokens[2];
				} else {
					rPrefered = tokens[2];
				}
			}
			
		}
		return operation;
	}
	
	
} // end class


	
