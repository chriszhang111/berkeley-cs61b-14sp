/* SListNode.java */

/**
 *  SListNode is a class used internally by the SList class.  An SList object
 *  is a singly-linked list, and an SListNode is a node of a singly-linked
 *  list.  Each SListNode has two references:  one to an object, and one to
 *  the next node in the list.
 *
 *  @author Kathy Yelick and Jonathan Shewchuk
 */

class SListNode {
  Object item; //filed of type Object
  SListNode next; // a pointer to the next element of type SListNode

  /**
   *  SListNode() (with one parameter) constructs a list node referencing the
   *  item "obj".
   */

  SListNode(Object obj) { //constructor
    item = obj;
    next = null;
  }

  /**
   *  SListNode() (with two parameters) constructs a list node referencing the
   *  item "obj", whose next list node is to be "next".
   */

  SListNode(Object obj, SListNode next) { //constructor
    item = obj;
    this.next = next;
  }

  //pangjac add set method
  void setItem(Object obj){
    this.item = obj;
  }

  //pangjac add setNext method
  void setNext(SListNode next){
    this.next = next;
  }

  Object getItem(){
    return this.item;
  }

  SListNode getNext(){
    return this.next;
  }


}
