import java.util.HashMap;
import java.util.Map;

public class distinctPair {
    public int countDistinctPair(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.containsKey(target - key) && map.get(target - key) > 0) {
                if (target / 2 == key && map.get(key) > 1) {
                    count++;
                    map.put(key, 0);
                } else {
                    count++;
                    map.put(key, 0);
                    map.put(target - key, 0);
                }
            }
         }
        return count;
    }

    public static void main(String[] args) {
        distinctPair test = new distinctPair();
        int[] numbers = {1,9,9,5,5,5,1,2,8,2,5,3};
        System.out.println(test.countDistinctPair(numbers, 10));
    }
}
