import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class countOfSmallerNumbersAfterSelf {
	
	// Binary Search Tree Version
	// Time: O(nlogn), Worst case: O(n^2) for decreasing order, Space: O(n); 
	public class Node{
	    int val, leftSum = 0, count = 0;
	    Node left, right;
	    public Node(int val){
	        this.val = val;
	    }
	}
	
	public List<Integer> countSmaller(int[] nums) {
	    Integer[] count = new Integer[nums.length];
	    if(nums.length == 0){
	        return Arrays.asList(count);
	    }
	    Node root = new Node(nums[nums.length - 1]);
	    for(int i = nums.length - 1; i >= 0; i--){
	        count[i] = insert(root, nums[i]);
	    }
	    return Arrays.asList(count);
	}
	
	private int insert(Node node, int num){
	    int sum = 0;
	    while(node.val != num){
	        if(node.val > num){
	            if(node.left == null) node.left = new Node(num);
	            node.leftSum++;
	            node = node.left;
	        }else{
	            sum += node.leftSum + node.count;
	            if(node.right == null) node.right = new Node(num);
	            node = node.right;
	        }
	    }
	    node.count++;
	    return sum + node.leftSum;
	}
	
	// merge sort solution
	// Time: O(nlogn), Space: O(n);
    public class Pair {
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Pair[] arr = new Pair[nums.length];
        Integer[] smaller = new Integer[nums.length];
        Arrays.fill(smaller, 0);
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        mergeSort(arr, smaller);
        res.addAll(Arrays.asList(smaller));
        return res;
    }
    
    private Pair[] mergeSort(Pair[] arr, Integer[] smaller) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);
        for (int i = 0, j = 0; i < left.length || j < right.length;) {
            if (j == right.length || i < left.length && left[i].val <= right[j].val) {
                arr[i + j] = left[i];
                smaller[left[i].index] += j;
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }
        return arr;
    }
    
    // binary indexed tree version
    // Time: O(nlogn), Space: O(n);
    // 1, we should build an array with the length equals to the max element of the nums array as BIT.
    // 2, To avoid minus value in the array, we should first add the (min+1) for every elements 
    // (It may be out of range, where we can use long to build another array. But no such case in the test cases so far.)
    // 3, Using standard BIT operation to solve it.
    public List<Integer> countSmaller3(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i]:min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i],max);
        }
        int[] tree = new int[max+1];
        for (int i = nums2.length-1; i >= 0; i--) {
            res.add(0,get(nums2[i]-1,tree));
            update(nums2[i],tree);
        }
        return res;
    }
    
    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num +=tree[i];
            i -= i&(-i);
        }
        return num;
    }
    
    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i] ++;
            i += i & (-i);
        }
    }
}

