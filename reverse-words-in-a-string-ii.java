/**Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
*
* The input string does not contain leading or trailing spaces and the words are always separated by a single space.

* For example,
* Given s = "the sky is blue",
* return "blue is sky the".
/
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
