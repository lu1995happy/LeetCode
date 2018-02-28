import java.util.HashMap;
import java.util.ArrayList;

public class intersectionOfTwoArraysII {
	
	// record the duplicate numbers 
	// using HashMap<Integer, Integer> to record the frequency of the number
	// and using ArrayList to record the result;
	
	public int[] intersect(int[] num1, int[] num2) {
		
		if (num1 == null || num2 == null || num1.length == 0 || num2.length == 0) {
			return new int[0];
		}
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
	
		for (int i = 0; i < num1.length; i++) {
			if (map.containsKey(num1[i])) 
				map.put(num1[i], map.get(num1[i]) + 1);	
			else 
				map.put(num1[i], 1);
		}
			
		for (int j = 0; j < num2.length; j++) {
			if (map.containsKey(num2[j]) && map.get(num2[j]) > 0) {
				result.add(num2[j]);
				map.put(num2[j], map.get(num2[j]) - 1);
			}
		}
		
		int i = 0;
		int[] res = new int[result.size()];
		for (Integer num : result) {
			res[i++] = num;
		}
		return res;
	}
	
	public static void main(String[] args) {
		intersectionOfTwoArraysII test = new intersectionOfTwoArraysII();
		int[] num1 = {1,2,2,1};
		int[] num2 = {2,2};
		int[] result = test.intersect(num1, num2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		
		int[] num3 = {1,1};
		int[] num4 = {1,2};
		int[] result1 = test.intersect(num3, num4);
		for (int i = 0; i < result1.length; i++) {
			System.out.print(result1[i] + " ");
		}
	}
}
