public class reserveVowels {
	//These letters are vowels in English: A, E, I, O, U, and sometimes Y.
	public String isReserveVowels(String s) {
		int i = 0;
		int j = s.length() - 1;
		char[] ch = s.toCharArray();
		String vowels = "AEIOUaeiou";
		while (i < j) {
			if ((i < j) || !(vowels.contains(ch[i]+""))) {
				i++;
			}
			if ((i < j) || !(vowels.contains(ch[j]+""))) {
				j--;
			}
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
	return new String(ch);
	}
}
