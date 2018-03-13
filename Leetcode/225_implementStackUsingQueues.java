import java.util.LinkedList;
import java.util.Queue;

public class implementStackUsingQueues {
	
	// push: O(n) time, pop/top: O(1) time;
	
	private Queue<Integer> queue;
	
	/** Initialize your data structure here. */
    public implementStackUsingQueues() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        // rotate the queue to make the tail be the head
        for (int i = 0; i < queue.size() - 1; i++) {
        		queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
