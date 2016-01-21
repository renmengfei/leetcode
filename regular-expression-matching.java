// Method 1: recursion

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
 
        boolean is_same = same(s,p);
        if (p.length()>1 && '*' == p.charAt(1))
            return (isMatch(s, p.substring(2)) || is_same && isMatch(s.substring(1), p));
        else
            return  is_same && isMatch(s.substring(1), p.substring(1));
    }
    
    
    public boolean same(String s, String p){
        return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0));
    }
}
