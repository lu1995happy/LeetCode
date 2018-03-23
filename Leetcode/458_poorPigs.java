
public class poorPigs {
	
	// In general, we can solve up to (⌊minutesToTest / minutesToDie⌋ + 1)pigs buckets this way, so just find the smallest 
	// sufficient number of pigs
	// Time: O(1), Space: O(1);
    // t^x >= buckets ==> x
    // <=> log(buckets) base t
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets-- == 1)
            return 0;
        int base = minutesToTest / minutesToDie + 1;
        int count = 0;
        while (buckets > 0) {
            buckets /= base;
            count++;
        }
        return count;
    }
}
