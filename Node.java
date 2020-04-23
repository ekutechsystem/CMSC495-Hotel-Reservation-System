// Project: Hotel-Reservation-System
// File:  Node.java

public class Node {

  Node next;//reference to the next node
  Object data;//data in the Node(could be of any type)
  
  
  //Node constructor
  public Node(Object dataValue) {
   next = null;//initializes next to null
   this.data = dataValue;//initializes data
  }

  //Accessory and Setter
  public Object getData() { return data; }
  public void setData(Object dataValue) { data = dataValue; }
  public Node getNext() { return next; }
  public void setNext(Node nextValue) { next = nextValue; }
  
  
  /**
   * toString
   * generates a string containing details of the node
   * input - none
   * output - string containing details of the node
   */
  public String toString(){
   String line="";
   //checks if data is an instance of Movies
   if(data instanceof Hotels){
    //stores the title of the movie into line
    line=((Hotels)data).toString();
   }
   //else if the data is an instance of Customers
   else if(data instanceof Rooms){
    //stores the name of the customer into line
    line=((Rooms)data).toString();
   } else if(data instanceof Customers) {
	   line = ((Customers)data).toString();
   } else {
	   line = data.toString();
   }
   
   return line;
  }

public int compare(Object data2) {
	// TODO Auto-generated method stub
	return 0;
}
 
}
 
