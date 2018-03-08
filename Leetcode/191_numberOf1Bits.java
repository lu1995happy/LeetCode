
public class numberOf1Bits {
	public int hammingWeight(int n) {
		int ones = 0;
    		while(n != 0) {
    			ones = ones + (n & 1);
    			n = n >>> 1;
    		}
    		return ones;
	}
	
	public static void main(String[] args) {
		numberOf1Bits test = new numberOf1Bits();
		System.out.println(test.hammingWeight(11));
	}
}
