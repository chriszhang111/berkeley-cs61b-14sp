package list;

public class LockDList extends DList{
	//constructor
  	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    	//super(item, prev, next); //call to super must be first statement in constructor
    	return new LockDListNode(item, prev, next);
  	}

	public void lockNode(DListNode node) {
		((LockDListNode)node).isLocked = true;
	}

	//The parameter really is supposed to be of static type DListNode, 
	//not LockDListNode, for the convenience of the users of your LockDList. 
	//Instead, it’s your job to takeit’s your job to take care of that cast (from DListNode to LockDListNode).
	public void remove(DListNode node){
		if(((LockDListNode)node).isLocked == false){
			super.remove(node);
		}
	}

}