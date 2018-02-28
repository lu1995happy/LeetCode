public class resverString {
	public String isReseverString(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
	
	public String wasReserveString(String s) {
		StringBuilder sb = new StringBuilder();
		char[] ch = s.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			sb.append(ch[i]);
		}
		return sb.toString();
	}
}
