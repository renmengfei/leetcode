// greedy choice按照index顺序，从左到右，找到第一个最小的字符
// 它的position满足：它左边的字符都比它大；它左边的字符count不是1， 例子“bcacd” 第一个找到的不是a，因为b只有一个，如果remove了，就没有了
// 找到字符后，它左边的可以全部删掉，它右边的进行recursion， 记得要replace它。
// O(25*n) 26个字母比较次数是25， n个人找身高最高的需要n-1
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        
        int pos = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<s.charAt(pos)) pos = i;
            if(--count[s.charAt(i)-'a']==0) break;
        }
        
        return s.length()==0? "": s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
    }
}
