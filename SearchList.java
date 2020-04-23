// Project: Hotel-Reservation-System
// File:  SearchList.java

class SearchList extends OrderList {
 
 private Node current;
 
 /**
  * initScan
  * returns the first object from the list
  * input - none
  * output - first object
  */
 public Object initScan() {
    Object result = null;
    //sets current to top
     current = getTop();
     //checks if current is not null
     if(current != null){
      //adds current's data to result
      result = current.getData();
     }
     //returns result
     return result;
 }
 
 /**
  * scan
  * updates current and returns the object in current
  * input - none
  * output - current's object
  */
 public Object scan() {
     Object result = null;
     //updates current to next node
     current = current.getNext();
     //checks if current is not null
     if(current != null){
      //adds current's data to result
      result = current.getData();
     }
     //returns result
     return result;
 }
 
 /**
  * getAt
  * returns an object at a particular position
  * input - position
  * output - object at that position
  */
 public Object getAt(int index){
     Object result = null;
     
     Node curr = getTop();
     while( curr != null) {
    	 if(curr.getData() instanceof Hotels ) {
    		 Hotels obj = (Hotels)curr.getData();
    		 if(obj.getID() == index ) {
    			 result = curr.getData();
    		 }
    	 }
    	 curr = curr.getNext();
     }
     
     return result;
 }

 /**
  * findIndex
  * returns the position of an object
  * input - object to be searched for
  * output - position of that object in the list
  */
// public int findIndex(Object target){
//  int pos=0;//initializes pos to 0
//  boolean found=false;//initializes found to false
//  
//  //creates two empty strings
//  String first="";
//  String second="";
//  
//  //sets curr to top
//  Node curr=getTop();
//  
//  //loop goes to till curr is not null && and object is not found
//  while(curr!=null&&!found){
//   //checks if curr and target are instance of Movies
//   if(curr.getData() instanceof Movies && target instanceof Movies){
//       //adds the title of curr to first
//    first=((Movies)curr.getData()).getTitle();
//    //adds the title of target to second
//    second=((Movies)target).getTitle();
//    //checks if the two trings are equal
//    if(first.compareToIgnoreCase(second)==0){
//     found=true;//sets found to true
//     
//    }
//    
//   }
//   //else if curr and target are instance of Customers
//   else if(curr.getData() instanceof Customers && target instanceof Customers){
//    //adds the name of curr to first
//    first=((Customers)curr.getData()).getName();
//    //adds the name of target to second
//    second=((Customers)target).getName();
//    //checks if the two trings are equal
//    if(first.compareToIgnoreCase(second)==0){
//     found=true;//sets found to true
//    }
//   }
//   
//   curr=curr.getNext();//updates curr to next node
//   //sets both strings to empty strings
//   first="";
//   second="";
//   //increments pos by 1
//   pos++;
//    
//  }
//  //checks if the object is not found
//  if(!found){
//   //sets pos to MIN_VALUE
//   pos=Integer.MIN_VALUE;
//  }
//  
//  //returns pos
//  return pos;
// }
 
 /**
  * search
  * searches for an object in the list
  * input - string to be searched for
  * output - object if found,null otherwise
  */
 public Object search(String target){
  
  boolean found=false;//sets found to false
  Object toReturn=null;//sets toReturn to null
  
  String first="";//creates an empty string
  
  Node curr=getTop();//sets curr to top
  Node prev=null;//sets prev to null
  
  //loop goes till curr is not null and object is not found
  while(curr!=null&&!found){
   //checks if curr is instance of Movies
   if(curr.getData() instanceof Hotels){
    //adds the title of curr to first
    first=((Hotels)curr.getData()).getName();
    //compares first with target
    if(first.compareToIgnoreCase(target)==0){
     found=true;//sets found to true if the two strings are the same
     
    }
    
   }
   //checks if curr is instance of Customers
   else if(curr.getData() instanceof Customers){
    //adds the name of curr to first
    first=((Customers)curr.getData()).getName();
//    //compares first with target
    if(first.compareToIgnoreCase(target)==0){
     found=true;//sets found to true if the two strings are the same
    }
   } else if(curr.getData() instanceof Rooms) {
	   first = ((Rooms)curr.getData()).getName();
	   if(first.compareToIgnoreCase(target) == 0) {
		   if( !((Rooms) curr.getData()).getOccupied() ) {
			   found = true;
		   }
	   }
   }
   
   prev=curr;//sets prev to curr
   curr=curr.getNext();//updates curr to the next node
   first="";//makes first empty
    
  }
  //checks if prev is not null and if object is found
  if(prev!=null&&found){
   //adds prev's data to toReturn
   toReturn=prev.getData();
  }
  
  return toReturn;
 }

}

