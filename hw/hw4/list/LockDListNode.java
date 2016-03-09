package list;
/*
define a LockDListNode class that extends DListNode and carries
information about whether it has been locked. 
LockDListNodes are not locked when they are first created. 
Your LockDListNode constructor(s) should call a DListNode constructor to avoid code duplication.
Second, define a LockDList class that extends DList
*/

public class LockDListNode extends DListNode{

	protected boolean isLocked;

	//LockDListNode constructor
	LockDListNode(Object i, DListNode p, DListNode n) {
		super(i, p , n);
		isLocked = false;
	}

}