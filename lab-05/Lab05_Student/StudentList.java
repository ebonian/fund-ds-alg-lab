
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		i1.currentNode.previousNode.nextNode = i2.currentNode;
		i2.currentNode.previousNode.nextNode = i1.currentNode;

		i1.currentNode.nextNode.previousNode = i2.currentNode;
		i2.currentNode.nextNode.previousNode = i1.currentNode;

		DListNode tempPrevious = i1.currentNode.previousNode;
		DListNode tempNext = i1.currentNode.nextNode;
		
		i1.currentNode.previousNode = i2.currentNode.previousNode;
		i2.currentNode.previousNode = tempPrevious;

		i1.currentNode.nextNode = i2.currentNode.nextNode;
		i2.currentNode.nextNode = tempNext;

	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) {
		DListNode nextNode = i1.currentNode.nextNode;
		DListNode previousNode = lst.header.previousNode;

		i1.currentNode.nextNode = lst.header.nextNode;
		lst.header.nextNode.previousNode = i1.currentNode;

		lst.header.previousNode.nextNode = nextNode;
		nextNode.previousNode = previousNode;

	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator mainIterator = new DListIterator(this.header);
		DListIterator insertionHelper = new DListIterator(this.header);

		printList();

		while (mainIterator.currentNode.nextNode != header) {
		    mainIterator.next();
		    
		    if ((((Student) mainIterator.currentNode.data).getSex()).equals(g)) {
		        super.insert(mainIterator.currentNode.data, insertionHelper);
		        insertionHelper.next();

		        mainIterator.currentNode.previousNode.nextNode = mainIterator.currentNode.nextNode;
		        mainIterator.currentNode.nextNode.previousNode = mainIterator.currentNode.previousNode;
		    }
		}

	}

}
