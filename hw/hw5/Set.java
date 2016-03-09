/* Set.java */

import list.*;

/**
 *  A Set is a collection of Comparable elements stored in sorted order.
 *  Duplicate elements are not permitted in a Set.
 **/
public class Set {
  /* Fill in the data fields here. */
  protected List setList;
  /**
   * Set ADT invariants:
   *  1)  The Set's elements must be precisely the elements of the List.
   *  2)  The List must always contain Comparable elements, and those elements 
   *      must always be sorted in ascending order.
   *  3)  No two elements in the List may be equal according to compareTo().
   **/

  /**
   *  Constructs an empty Set. 
   *  Set.jav shuold be abaole to switch between DList and SList by changing 
   *  One constructor call in the Set() constructor.
   *  Performance:  runs in O(1) time.
   **/
  public Set() { 
    // Your solution here.
    setList = new DList();
  }

  /**
   *  cardinality() returns the number of elements in this Set.
   *
   *  Performance:  runs in O(1) time.
   **/
  public int cardinality() {
    // Replace the following line with your solution.
    return setList.length();
  }

  /**
   *  insert() inserts a Comparable element into this Set.
   *
   *  Sets are maintained in sorted order.  The ordering is specified by the
   *  compareTo() method of the java.lang.Comparable interface.
   *  
   * Should declare variables of static type List and ListNode in Set.java, not
   * variables of type DList, DListNode, SList, or SListNode.
   *  Performance:  runs in O(this.cardinality()) time.
   **/

  public void insert(Comparable c) {
    //declare variables of static type List and ListNode
    if (c==null) {
      return;
    }
    if (this.cardinality()==0){ //empty set 
      setList.insertFront(c);
      return;
    }
   
	try {
		ListNode thisNode = setList.front();
		//while loop can help make sure the insert behavior is always ordered from small to big.
		while (thisNode.isValidNode() && ((Comparable) thisNode.item()).compareTo(c) < 0) {
			thisNode = thisNode.next();
		} if (((Comparable) thisNode.item()).compareTo(c) == 0) {
			//return ; // this to-be-insert node is the same as curr, do nothing and move on
		} else {//only when find to-be-insert node c is smaller, than insert c into curr
			thisNode.insertBefore(c);
		}
	} catch (InvalidNodeException e) {// reached at the end of "this" w/out finding any element in "this " greater than c.
		setList .insertBack(c);
	}
    }


  /**
   *  union() modifies this Set so that it contains all the elements it
   *  started with, plus all the elements of s.  The Set s is NOT modified.
   *  Make sure that duplicate elements are not created.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Your implementation should NOT copy elements of s or "this", though it
   *  will copy _references_ to the elements of s.  Your implementation will
   *  create new _nodes_ for the elements of s that are added to "this", but
   *  you should reuse the nodes that are already part of "this".
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
   **/
  public void union(Set s) {
    // Your solution here.
    if (s.cardinality()==0){
      System.out.println("set s" + s.toString() + " is empty");
    }
    if (this.cardinality()==0){
      this.setList = s.setList;
    }

    ListNode thisNode = this.setList.front();
    ListNode sNode = s.setList.front();

    try{
      while (thisNode.isValidNode() && sNode.isValidNode()){
        if (((Comparable) thisNode.item()).compareTo((Comparable)sNode.item())<0){ // this is smaller
            thisNode = thisNode.next();
        }
        else if(((Comparable) thisNode.item()).compareTo((Comparable)sNode.item())==0){ // equal
          thisNode = thisNode.next();
          sNode = sNode.next();
        }
        else { //this is bigger
          thisNode.insertBefore(sNode.item());
          sNode = sNode.next();
        }
      }

      while (sNode.isValidNode()){
        this.setList.insertBack((Comparable)sNode.item());
        sNode = sNode.next();
      }
    }
    catch (InvalidNodeException e){//the to-insert node is greater than all nodes in "this"
        System.out.println("union() " + s.toString() + "failed");
        Thread.dumpStack();
    }
  }

  /**
   *  intersect() modifies this Set so that it contains the intersection of
   *  its own elements and the elements of s.  The Set s is NOT modified.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Do not construct any new ListNodes during the execution of intersect.
   *  Reuse the nodes of "this" that will be in the intersection.
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT CONSTRUCT ANY NEW NODES.
   *  DO NOT ATTEMPT TO COPY ELEMENTS.
   **/
  public void intersect(Set s) {
    // Your solution here.
    if (s==null || this.cardinality()==0 ){
      System.out.println("Given Set is null.");
      return;
    }

    ListNode thisNode = setList.front();
    ListNode sNode = s.setList.front();
    try{
      while (thisNode.next().isValidNode() && sNode.isValidNode()){

        if (((Comparable) thisNode.item()).compareTo((Comparable)sNode.item())<0){ // this is smaller
            thisNode = thisNode.next();
            thisNode.prev().remove();
        }
        else if(((Comparable) thisNode.item()).compareTo((Comparable)sNode.item())==0){ // intersect
          thisNode = thisNode.next();
          sNode = sNode.next();
        }
        else{ 
          sNode = sNode.next();
        }
      }

      //remove all the rest nodes in "this" (that not in Set s)
      while (thisNode.isValidNode()){
        ListNode tmpnext = thisNode.next();
        thisNode.remove();
        thisNode = tmpnext;
      }
    }
    catch (InvalidNodeException e){//the to-insert node is greater than all nodes in "this"
        System.out.println("intersect() " + s.toString() + "failed");
        Thread.dumpStack();
    }
  }
  

  /**
   *  toString() returns a String representation of this Set.  The String must
   *  have the following format:
   *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
   *            between them.
   *    {  1  2  3  } for a Set of three Integer elements.  No spaces before
   *            "{" or after "}"; two spaces before and after each element.
   *            Elements are printed with their own toString method, whatever
   *            that may be.  The elements must appear in sorted order, from
   *            lowest to highest according to the compareTo() method.
   *
   *  WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
   *            FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
   *            DEVIATIONS WILL LOSE POINTS.
   **/

  public String toString() {
    // Replace the following line with your solution.
    //return "";
    if (this.cardinality() ==0){
      return "{ }";
    }

    String str = "{ ";
    int count = 0;
    ListNode node = setList.front();

    try{
      while(count<this.cardinality() && node.isValidNode()){
        str = str + " " + node.item();
        node = node.next();
        count++;
      }
    } catch (InvalidNodeException e){
      Thread.dumpStack();
    }

    return str + " }";
  }

  public static void main(String[] argv) {
     Set s = new Set();
     s.insert(new Integer(6));
     s.insert(new Integer(4));
     s.insert(new Integer(3));
     System.out.println("Set s = " + s);

    Set s2 = new Set();
    //s2.insert(new Integer(3));
    s2.insert(new Integer(4));
    s2.insert(new Integer(5));
    s2.insert(new Integer(5));
    System.out.println("Set s2 = " + s2);
//
     Set s3 = new Set();
     s3.insert(new Integer(7));
     s3.insert(new Integer(9));
     s3.insert(new Integer(8));
     System.out.println("Set s3 = " + s3);
//
     s.union(s2);
     System.out.println("After s.union(s2), s should be { 3 4 5 6 } " + s);

     s.intersect(s3);
     System.out.println("After s.intersect(s3), s = " + s);
     System.out.println("s.cardinality() = " + s.cardinality());
    // You may want to add more (ungraded) test code here.
  }
}
