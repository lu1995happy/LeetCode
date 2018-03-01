import java.util.HashMap;;

public class studentAttendanceRecordI {
	public boolean checkRecord(String s) {
		
		// return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
		// return !s.matches(".*LLL.*|.*A.*A.*");
		// or use a to count the number of 'A';
		// and l to record the continuous of L, set it to 0 if another word comes out;
		
		HashMap<Character, Integer> map = new HashMap<>();
		char[] record = s.toCharArray();
 		for (int i = 0; i < record.length; i++) {
			if (map.containsKey(record[i])) 
				map.put(record[i], map.get(record[i]) + 1);
			else
				map.put(record[i], 1);
			
			if (map.get('A') != null && map.get('A') > 1) 
				return false;
			
			if (i >= 2)
				if (record[i] == 'L' && record[i-1] == 'L' && record[i-2] == 'L')
					return false;
		}
 		return true;
	}
	
	public boolean checkString(String s) {
	
		int a = 0, l = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'A') {
				a++;
				l = 0;
				if (a > 1) 
					return false;
			}
			else {
				if (ch == 'L') {
					l++;
					if (l > 2) 
						return false;
				}
				else 
					l = 0;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		studentAttendanceRecordI test = new studentAttendanceRecordI();
		System.out.println(test.checkString("PPALLP"));
		System.out.println(test.checkString("PPALLL"));
		System.out.println(test.checkString("PPALPLL"));
		System.out.println(test.checkString("PPAALLAL"));
		System.out.println(test.checkString("LLLL"));
	}
}
