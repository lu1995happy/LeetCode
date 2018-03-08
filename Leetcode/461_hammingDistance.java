
public class hammingDistance {
	public int hammingDistance(int x, int y) {
        int res = x^y;
        int count = 0;
        while(res != 0) {
        		count += res & 1;
            res = res >> 1;
        }           
        return count;
 
		//return Integer.bitCount(x ^ y);
	}
	
	public static void main(String[] args) {
		hammingDistance test = new hammingDistance();
		System.out.println(test.hammingDistance(1, 4));
	}
}
