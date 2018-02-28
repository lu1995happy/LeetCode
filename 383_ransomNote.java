public class ransomNote {
	public boolean canConstruct (String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		int[] check = new int[128];
		for (int i = 0; i < magazine.length(); i++) {
			char ch = magazine.charAt(i);
			check[ch]++;
		}
		for (int j = 0; j < ransomNote.length(); j++) {
			char ch = ransomNote.charAt(j);
			check[ch]--;
			if (check[ch] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ransomNote ran = new ransomNote();
		System.out.println(ran.canConstruct("aaaa", "aaab"));
		System.out.println(ran.canConstruct("aaaa", "aaaab"));
	}
}
