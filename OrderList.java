// Project: Hotel-Reservation-System
// File:  OrderList.java

class OrderList extends List {

 /**
  * insertOrder
  * inserts an object in order into the list
  * input - object to be inserted
  * output - none
  */
 public void insertOrder(Object newItem) {

  //creates a new node
  Node newNode = new Node(newItem);

  //checks if the list is empty
  if (isEmpty()) {
   //sets top to newNode
   setTop(newNode);
  } 
  else {
   Node curr = getTop();//sets curr to top
   Node prev = null;//sets prev to null

   //compares curr to newNode
   int res = curr.compare(newNode.getData());
   
   //loop goes till curr is not null and till res < 0
   while (curr != null && res < 0) {
    prev = curr;//sets prev to curr
    curr = curr.getNext();//updates curr to the next node
    if (curr != null) {//checks if curr is not null
     //compares curr to newNode
     res = curr.compare(newNode.getData());
    }
   }

   //checks if it is not a duplicate
   if (res != 0) {
    //checks if prev is null (add at front)
    if (prev == null) {
     //sets prev to newNode
     prev = newNode;
     //sets the next of newNode to top
     newNode.setNext(getTop());
     //sets top to newNode
     setTop(newNode);
    }
    //else if curr is null and prev is not null(insert at last)
    else if (curr == null && prev != null) {
     //sets next of prev to newNode
     prev.setNext(newNode);
     //sets next of newNode to null
     newNode.setNext(null);
    } 
    else {//adding in between
     //sets next of newNode to curr
     newNode.setNext(curr);
     //sets next of prev to null
     prev.setNext(newNode);
    }
   }

  }
  //increments numItems by 1
  incrementNumItems();
  
 }

}

