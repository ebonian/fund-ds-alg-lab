class ListNode {
	// Constructors
	ListNode(Object theElement) {
		this(theElement, null);
	}

	ListNode(Object theElement, ListNode n) {
		data = theElement;
		nextNode = n;
	}

	// Friendly data; accessible by other package routines
	Object data;
	ListNode nextNode;
}

public class LinkedList {
	ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}
	//

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = null;
	}

	public void insert(Object value, Iterator p) throws Exception {
		if (p == null || !(p instanceof MyListIterator))
			throw new Exception();
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();
		ListNode n = new ListNode(value, p2.currentNode.nextNode);
		p2.currentNode.nextNode = n;
	}

	public int find(Object value) throws Exception {
		Iterator itr = new MyListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v.equals(value))
				return index; // return the position of value.
		}
		return -1;
	}

	public Iterator findPrevious(Object value) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		Object currentData = itr2.next();
		while (!currentData.equals(value) && itr2.hasNext()) {
			currentData = itr2.next();
			itr1.next();
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}

	public void remove(Iterator p) {
		if (p == null || !(p instanceof MyListIterator))
			return;
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null || p2.currentNode.nextNode == null)
			return;
		p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
	}

	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// Returns the number of data stored in this list.
	// To be completed by students.
	public int size() throws Exception {
		int count = 0;
		Iterator itr = new MyListIterator(header);

		while (itr.hasNext()) {
			itr.next();
			count++;
		}

		return count;
	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new MyListIterator(header);

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	// Return iterator pointing to value that stores a given name, or null
	// otherwise.
	// To be completed by students.
	public Iterator findPosition(String name) throws Exception {
		Iterator itr = new MyListIterator(header);

		while (itr.hasNext()) {
			Object value = itr.next();

			if (value instanceof Contact) {
				Contact c = (Contact) value;

				if (c.name.equals(name)) {
					return itr;
				}
			}
		}

		return null;
	}

	// add a new contact to the list the contact must be added in such a way that
	// each contact is sorted by name, in alphabetical order.
	public void add(Object c) throws Exception {
		MyListIterator p2 = new MyListIterator(header);

		while (p2.hasNext()) {
			p2.currentNode = p2.currentNode.nextNode;

			if (((Contact) c).name.compareTo(((Contact) p2.currentNode.data).name) < 0) {
				p2 = (MyListIterator) this.findPrevious(((Contact) p2.currentNode.data));
				break;
			}
		}

		this.insert(c, p2);
	}

	// Remove the contact pointed by the iterator, i, and then returns an iterator
	// pointing to the next contact.
	// If the removed contact is the last one, return the iterator pointing to the
	// first contact
	// (if there is no first contact, make the iterator point to header).
	// If i is marking an illegal position that cannot be removed, just return null.
	// To be completed by students.
	public Iterator removeAt(Iterator i) throws Exception {
		if (i == null || !(i instanceof MyListIterator)) {
			return null;
		}

		MyListIterator p2 = (MyListIterator) i;

		if (p2.currentNode == null || p2.currentNode.data == null) {
			return null;
		}

		MyListIterator p1 = (MyListIterator) findPrevious(p2.currentNode.data);
		MyListIterator h = (MyListIterator) new MyListIterator(header);
		remove(p1);

		if (p2.hasNext()) {
			p2.currentNode = p2.currentNode.nextNode;
			return p2;
		}

		if (h.hasNext()) {
			h.currentNode = h.currentNode.nextNode;
			return h;
		}

		return h;
	}

}