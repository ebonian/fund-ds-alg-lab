
public class MaxIntHeap extends Heap{
	public void add(Object element) {
		// Add your code here
		if (++size == mData.length) {
			Object[] newHeap = new Object[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		
		mData[size - 1] = element;
		
		percolateUp();		
	}
	public Object pop() throws Exception {
		// Add your code here
		if (size == 0) {
			throw new Exception("Priority queue empty.");
		}
		
		int max = 0;
		
		for (int i=0;i<size;i++) {
			if((int) mData[i]>(int)mData[max]) {
				max=i;
			}
		}
		
		int maxElem=(int) mData[max];
		
		mData[max] = mData[size - 1];
		
		size--;
		
		percolateDown(max);
		
		return maxElem;	
	}
}
