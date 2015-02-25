// Method 1: 倒序
public class Solution {
   public int lengthOfLastWord(String s) {
		int result = 0;
		
		s = s.trim();
		int end = s.length()-1;
		while(end>=0){
			if(s.charAt(end)==' ') break;
			result++;
			end--;
		}
		
		return result;
	}
}


//Method 2: 正序
public class Solution {
    public int lengthOfLastWord(String s) {
        s= s.trim();
        int n = s.length();

        int count = 0;
        for(char c:s.toCharArray()){
            if(c!=' ') count++;
            else count = 0;
        }

        return count;
    }
}
