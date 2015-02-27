public class Solution {
    public String addBinary(String a, String b) {
		if(a==null) return b;
		if(b==null) return a;
		StringBuffer result = new StringBuffer();
		
		int ap = a.length()-1;
		int bp = b.length()-1;
		
		int carry = 0;
		// important, use OR instead of &&
		while(ap>=0 || bp>=0 || carry==1){
			int avalue = ap>=0?a.charAt(ap--)-'0':0;
			int bvalue = bp>=0?b.charAt(bp--)-'0':0;
			
			int sum = avalue+bvalue+carry;
			result.insert(0, sum%2);
			carry = sum/2;
		}
		return result.toString();
	}
}
