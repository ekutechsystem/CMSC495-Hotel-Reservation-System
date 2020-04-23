
public class Database {
	private static List hotelList;
	private static List customerList;
	//private static List roomList;
	
	public Database() {
		hotelList = new SearchList();
		customerList = new SearchList();
	}
	
	public void addHotel(String name, int ID) {
		Hotels hotelObj = null;
		
		hotelObj = ((Hotels) ((SearchList) hotelList).search(name));
		
		if(hotelObj == null) {
			hotelObj = new Hotels(name, ID);
			hotelList.add(hotelObj);
		}
	}
	
	
	public void addRoom(String name, String type, int rate){
		Object obj = ((Hotels) ((SearchList) hotelList).search(name));
		((Hotels)obj).addRoom(type, rate, ((Hotels)obj));
	}
	
	public void addReservation(int startDate, int duration,int ID, Customers cus ) {
		if(duration > 1) {
			Object hotelObj = ((Hotels) ((SearchList) hotelList).getAt(ID));
			//Object cusObj = ((Customers) ((SearchList) customerList).search(cus.getName()));
			if(hotelObj != null) {
				Reservations resObj = new Reservations(startDate, duration, cus);
				if(cus.getrPref() == null ) {
					Object result = ((Hotels)hotelObj).searchRooms();
					if(result != null ) {
						((Rooms)result).setOccupied(true);
						((Hotels)hotelObj).addRes(resObj);
						//((Hotels)hotelObj).print();
					} else {
						
					}
					
				} else {
					String pref = cus.getrPref();
					char c = pref.charAt(0);
					if(Character.isLetter(c)) {
						String roomType = (pref);
						Object availRoom = ((SearchList) ((Hotels) hotelObj).getrList()).search(roomType);
						if( availRoom != null) {
							((Rooms)availRoom).setOccupied(true);
							((Hotels)hotelObj).addRes(resObj);
						} else {
							availRoom = ((Hotels)hotelObj).searchRooms();
							if( availRoom != null) {
								((Rooms)availRoom).setOccupied(true);
								((Hotels)hotelObj).addRes(resObj);
							}
						}
					}
				}
				
				
			} else {
				System.out.println("There's no hotel with the name provided");
			}
		}
	}
	
	public Customers addCustomer(String lName, String fName, String rPrefered) {
		Customers cusObj = null;
		cusObj = ((Customers) ((SearchList) customerList).search(lName + " " + fName));
		
		if(cusObj == null) {
			cusObj = new Customers(lName + " " + fName, rPrefered);
			customerList.add(cusObj);
		} else {
			cusObj.setrPref(rPrefered);
		}
		//cusObj.getList().print();
		return cusObj;
	}
	
	public void cancelRes(int startDate, int hotelID) {
		
	}
	
	
	public void hotelprint() {
		hotelList.print(); 
		//roomList.print();
	}
	
	public void cusPrint() {
		customerList.print();
	}
	
	//public void resPrint() {
		//List list = getList();
	//}
}
