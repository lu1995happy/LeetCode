import java.util.Stack;

public class validParentheses {
	public boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		boolean check = false;
		Stack<Character> chStack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == ')') {
				if (chStack.isEmpty()) {
					return false;
				}
				if (chStack.peek() != '(') {
					return false;
				} else {
					chStack.pop();
					check = false;
				}
			} else {
					if (ch == '}') {
						if (chStack.isEmpty()) {
							return false;
						}
						if (chStack.peek() != '{' || chStack.isEmpty()) {
							return false;
						} else {
							chStack.pop();
							check = false; 
						}
					}
					else {
						if (ch == ']') {
							if (chStack.isEmpty()) {
								return false;
							}
							if (chStack.peek() != '[' || chStack.isEmpty()) {
								return false;
							} else {
								chStack.pop();
								check = false;
							}
						} else {
							chStack.push(ch);
							check = true;
						}
					}
			}
		}
		if (check) {
			return false;
		}
		return true;
	}
	
	public boolean isValidString(String s) {
		Stack<Character> chStack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				chStack.push(')');
			} else {
				if (ch == '{') {
					chStack.push('}');
				} else {
					if (ch == '[') {
						chStack.push(']');
					} else {
						if (chStack.isEmpty() || chStack.pop() != ch) {
							return false;
						}
					}
				}
			}
		}
		return chStack.isEmpty();
	}
	
	public static void main(String[] args) {
		validParentheses valid = new validParentheses();
		System.out.println(valid.isValid("(()"));
		System.out.println(valid.isValid("(())"));
		System.out.println(valid.isValid("({)}"));
		System.out.println(valid.isValid("((())){{{}}}[]"));
		System.out.println(valid.isValid("((([]))){{{}}}[]"));
		System.out.println(valid.isValid(")("));
		System.out.println(valid.isValid("(("));
	}
}
