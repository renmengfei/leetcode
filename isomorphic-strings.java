// Method 1: 不用hashmap,
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i)+256]) return false;
            m[s.charAt(i)] = m[t.charAt(i)+256] = i+1;
        }
        return true;
    }
}

// Method 2: 正常方法

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null && t!=null) return false;
        if(s!=null && t==null) return false;
        if(s==null && t==null) return true;
        
        if(s.length()!=t.length()) return false;
        
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            
            if(map.containsKey(s1)){
                if( map.get(s1)!=t1) return false;
            }
	    // bug: "ab" "aa", 不是一对一的关系，所以必须看是否1:1
            else if(map.containsValue(t1)){
                 return false;
            }
            else{
                map.put(s1,t1);
            }
        }
        return true;
    }
}
