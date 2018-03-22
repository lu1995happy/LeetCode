
public class containerWithMostWater {
	
	// two pointers : Time: O(n), Space: O(1);
	public int maxArea(int[] height) {
		int res = 0, low = 0, high = height.length - 1;
		while (low < high) {
			res = Math.max(res, Math.min(height[low], height[high]) * (high - low));
			if (height[low] < height[high])
				low++;
			else 
				high--;
		}
		return res;
	}
}
