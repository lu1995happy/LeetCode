import java.util.Stack;

public class dailyTemperatures {
	
	// Time: O(n), Space: O(n);
	public int[] dailyTemperatures (int[] temperatures) {
		int n = temperatures.length;
		if (temperatures == null || n == 0) {
			return temperatures;
		}
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				res[index] = i - index;
			}
			stack.push(i);
		}
		return res;
	}
	
	// Time: O(n), Space: O(n);
	public int[] dailyTemperatures2 (int[] temperatures) {
		int n = temperatures.length;
		if (temperatures == null || n == 0) {
			return temperatures;
		}
		int[] res = new int[n];
		int[] stack = new int[n];
		int top = -1;
		for (int i = 0; i < n; i++) {
			while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
				int index = stack[top--];
				res[index] = i - index;
			}
			stack[++top] = i;
		}
		return res;
	}
}
