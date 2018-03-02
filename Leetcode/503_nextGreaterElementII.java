import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElementII {
	
	//Time: O(n); Space: O(n);
	public int[] nextGreaterElement(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);
		for (int i = 0; i < n * 2; i++) {
			int number = nums[i % n];
			while (!stack.isEmpty() && nums[stack.peek()] < number) 
				res[stack.pop()] = number;
			if (i < n) 
				stack.push(i);
		}
		return res;
	}
	
    public int[] nextGreaterElements(int[] nums) {
        int[] stack = new int[2 * nums.length];
        int top = -1;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            int idx = i % nums.length;
            while (top >= 0 && nums[stack[top]] < nums[idx])
                res[stack[top--]] = nums[idx];
            stack[++top] = idx;
        }
        return res;
    }
	
	public static void main(String[] args) {
		nextGreaterElementII test = new nextGreaterElementII();
		int[] nums = {1,2,1};
		int[] res = test.nextGreaterElement(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}
}
