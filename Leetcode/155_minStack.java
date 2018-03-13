import java.util.Stack;

public class minStack {
	
	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
	
	// Time: O(1), Space: O(n);
	private Stack<Integer> stack;
	private int min;
	
	// initialize your data structure here. 
	public minStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}
	
	public void push(int x) {
		// only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}
	
	public void pop() {
		// if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
		if (stack.pop() == min) {
			min = stack.pop();
		}
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return min;
	}
}
