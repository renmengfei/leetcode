public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null && t!=null) return false;
        if(s!=null && t==null) return false;
        if(s==null && t==null) return true;
        if(s.length()!=t.length()) return false;
        int[] cache = new int[26];
        
        for(int i=0; i<s.length();i++){
            cache[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<t.length();i++){
            cache[t.charAt(i)-'a']--;
        }
        
        for(int i=0;i<26;i++){
            if(cache[i]!=0) return false;
        }
        return true;
        
    }
}
