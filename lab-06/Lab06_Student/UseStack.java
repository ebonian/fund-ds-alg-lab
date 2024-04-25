
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack sortedStack = new ArrayListStack();

        while (!s.isEmpty()) {
            int temp = s.top();
            s.pop();
            while (!sortedStack.isEmpty() && sortedStack.top() > temp) {            	
                s.push(sortedStack.top());
                sortedStack.pop();
            }
            sortedStack.push(temp);
        }

        return sortedStack;
	}

}

