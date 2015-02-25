public class Solution {
  public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;

				char cleft = stack.pop();
				if (c == ')' && cleft != '(')
					return false;
				if (c == ']' && cleft != '[')
					return false;
				if (c == '}' && cleft != '{')
					return false;
			}
		}
		// bug: check if stack is empty
		if (stack.isEmpty())
			return true;
		return false;
	}
}
