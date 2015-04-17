public class Solution {
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);
        
        int start = 0;
	// bug: end <=s.length,否则，最后一个word没有end
        for(int end=0;end<=s.length;end++){
            if(end==s.length || s[end]==' '){
                reverse(s,start,end-1);
                start=end+1;
            }
        }
    }
    
    public void reverse(char[] s, int start, int end){
        if(start>=end) return;
        while(start<end){
            char c = s[start];
            s[start++]=s[end];
            s[end--]=c;
        }
    }
}
