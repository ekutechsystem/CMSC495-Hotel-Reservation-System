// Project: Hotel-Reservation-System
// File:  Hotels.java

class Hotels extends Information {

	private List roomList;

	public Hotels(String name, int ID) {

		super(name, ID);
		roomList = new SearchList();
		
	}
	public void addRoom(String type, int rate, Hotels hotel) {
		Rooms roomObj = new Rooms( type, rate, hotel);
		roomList.add(roomObj);
	}
	
	public Object searchRooms() {
		Object result = null;
		result = roomList.traversal();
		return result;
	}
	
	public Object getrList() { return roomList; }
	
	public List rList() {
		return roomList;
	}
//	public void printRooms() {
//		roomList.print();
//	}
		
}
