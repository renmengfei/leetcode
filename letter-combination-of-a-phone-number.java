// Method 1: FIFO queue巧妙的利用位数,利用array的index作为hashmap
public class Solution {
  	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<String>();
		if (digits.isEmpty())
			return result;
		// Use array instead of HashMap to save storage
		String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));// digits.charAt(i)-'0'
			while (result.peek().length() == i) {
				String t = result.remove();
				for (char s : mapping[x].toCharArray())
					result.add(t + s);
			}
		}
		return result;
	}
}

// Method 2: recurvise
public class Solution {
    public String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
  	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<String>();
		if (digits.isEmpty())
			return result;
		combination("",digits, 0,result);
		return result;
	}
	
	public void combination(String path, String digits, int level, List<String> result){
		if(level>=digits.length()){
			result.add(path);
			return;
		}
		int x = Character.getNumericValue(digits.charAt(level));
		String strings = mapping[x];
		for(char c: strings.toCharArray()){
			combination(path+c, digits, level+1, result);
		}
	}
}
