// Project: Hotel-Reservation-System
// File:  List.java

class List {
 
 private Node top;
 private Node end;
 private int numItems;
 
 //constructor
 public List(){
  top = null;//sets top to null
  end = null;//sets end to null
  numItems = 1;//initializes numItems to 1
 }
 
 //getter for top
 public Node getTop(){ return top; }
 
 //setter for top
 public void setTop(Node newNode){ top=newNode; }
 
 //getter for numItems
 public int getCount(){ return numItems; }
 
 
 /**
  * isEmpty
  * returns true if the list is empty,false otherwise
  */
 public boolean isEmpty(){ return top == null; }
 
 /**
  * incrementNumItems
  * increases the number of items by 1
  */
 public void incrementNumItems(){ numItems++; }
 
 public void add(Object item) {
	 Node newNode = new Node(item);
	 
	 if( top == null && end == null) {
		 top = newNode;
		 end = newNode;
	 } else {
		 end.setNext(newNode);
		 end = newNode;
	 }
	 numItems++;
 }

 /**
  * removeFront
  * removes the first node from the list
  * input - none
  * output - none
  */
 public void removeFront(){

  if (top != null){
   //updates top to the next node
   top = top.getNext();
  }
  //decreases numItems by 1
  numItems--;
 }
 
 
 /**
  * remove
  * removes a node from a particular position in the list
  * input - position
  * output - none
  */
 public void remove(int index) {
  Node curr = top;//sets curr to top
  Node prev = null;//sets prev to null
  numItems--;//decreases numItems by 1
  //loop goes till curr is not null and index > 1
  while(curr != null & index > 1){
   index--;//decreases index by 1
   prev=curr;//sets prev to curr
   curr=curr.getNext();//updates curr to next node
 
  }
  //checks if prev is null
  if(prev==null){
   //updates top to the next node
   top=top.getNext();
  }
  else{
	  //else if prev is not null
   //sets next of prev to next of curr
   prev.setNext(curr.getNext());
  }
 }
 
 public Object traversal() {
	 Object result = null;
	 int minCost = Integer.MAX_VALUE;
	 Node curr = getTop();
	 while(curr != null ) {
		 if( curr.getData() instanceof Rooms) {
			 Rooms rObj = (Rooms)curr.getData();
			 if(!rObj.getOccupied()) {
				 if(rObj.getRate() < minCost) {
					 minCost = rObj.getRate();
					 result = rObj;
				 }
				 
			 }
		 }
		 curr = curr.getNext();
	 }
	 return result;
 }
 
 /**
  * print
  * prints the details of the list
  * input - none
  * output - none
  */
 public void print(){
  Node curr = top;//sets curr to top
  
  //loop goes till curr is not null
  while(curr != null){
   //checks if curr is an instance of Moies
   if(curr.getData() instanceof Hotels){
    //prints the current node
    System.out.println("\n"+curr);
   }
    if( curr.getData() instanceof Hotels ) {
    	Object obj = curr.getData();
//    
    	List rList = ((Hotels)obj).rList();
    	rList.print();
    }

  
//   else if curr is an instance if Customers
  else if(curr.getData() instanceof Customers){
	   System.out.println( curr);
   } else {
	   System.out.println(curr);
   }
    
   curr=curr.getNext();//updates curr to next node
  }
 
 }

 public String print2(){
     String printing = "";
     Node curr = top;//sets curr to top

     //loop goes till curr is not null
     while(curr != null){
         //checks if curr is an instance of Moies
         if(curr.getData() instanceof Hotels){
             //prints the current node
             printing = printing + "\n" + curr;
             printing = printing + "\n";
         }
         if( curr.getData() instanceof Hotels ) {
             Object obj = curr.getData();
//
             List rList = ((Hotels)obj).rList();
             rList.print();
         }


//   else if curr is an instance if Customers
         else if(curr.getData() instanceof Customers){
             printing = printing + curr;
             printing = printing + "\n";
         } else {
             printing = printing + curr;
             printing = printing + "\n";
         }

         curr=curr.getNext();//updates curr to next node
     }
     return printing;
 }
 
}

