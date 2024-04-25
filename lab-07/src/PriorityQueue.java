
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if (q.isEmpty()) {
			q.insertLast(x);
			return;
		}
		
		int size = q.size();
		
		boolean inserted = false;

		for (int i = 0; i < size; i++) {
			int thisQ = q.removeFirst();
			
			if (x < thisQ && !inserted) {
				q.insertLast(x);
				inserted = true;
			}
			
			q.insertLast(thisQ);
		}
		
		if (!inserted) {
			q.insertLast(x);
		}
	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return q.front();
	}

}
