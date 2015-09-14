//记住，处理length不一样长的办法
public class Solution {
    public String addBinary(String a, String b) {
		if(a==null) return b;
		if(b==null) return a;
		StringBuffer result = new StringBuffer();
		
		int ap = a.length()-1;
		int bp = b.length()-1;
		
		int carry = 0;
		// important, use OR instead of &&
		// c1=0, c2=0这种方法跟Compare Version Numbers 一样
		while(ap>=0 || bp>=0 || carry==1){
                    int c1=0, c2=0;
                    if(ap>=0) c1 = a.charAt(ap--)-'0';
                    if(bp>=0) c2 = b.charAt(bp--)-'0';
                    result.insert(0, (c1+c2+carry)%2);
                    carry = (c1+c2+carry)/2;
		}
		return result.toString();
	}
}
