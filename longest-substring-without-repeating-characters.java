// 用start指针的好处 no need to pop out previous record
public class Solution {
   	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				start = Math.max(start, map.get(c) + 1);
			}
			map.put(c, i);
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
}
