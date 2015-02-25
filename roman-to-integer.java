public class Solution {
	public int romanToInt(String s) {
		 int res=0;
	     int i;
	     char[] cstr = s.toCharArray();
	     for(i=0;i<cstr.length-1;i++){
	            if(getInt(cstr[i])>=getInt(cstr[i+1])) res+=getInt(cstr[i]);
	            else res-=getInt(cstr[i]);
	        }
	        res+=getInt(cstr[i]);
	        return res;
	}

	public int getInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
}
