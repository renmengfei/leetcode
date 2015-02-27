// Using commonlength can save time, and no need for 
public class Solution {
    public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		
		int commonlength = strs[0].length();
		String pivot = strs[0];
		
		for(int i=1;i<strs.length;i++){
			String s = strs[i];
			if(s.length()<commonlength) commonlength = s.length();
			for(int j=0;j<commonlength;j++){
				if(pivot.charAt(j)!=s.charAt(j)){
					commonlength = j;
				}
			}
		}
		return pivot.substring(0,commonlength);
	}
}
