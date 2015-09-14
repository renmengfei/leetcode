// diff很巧妙
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        
        if(sl>tl) return isOneEditDistance(t, s);
        
        int diff=tl-sl;
        if(diff>1) return false;
        
        int i = 0;
        while(i<sl && s.charAt(i)==t.charAt(i)) i++;
        if(i==sl) return diff>0;
        if(diff==0) i++;
        while(i<sl && s.charAt(i)==t.charAt(i+diff)) i++;
        return i==sl;
        
    }
}
