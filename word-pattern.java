public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
         HashMap<String, Character> map2 = new HashMap<String, Character>();
         
        String[] strs = str.trim().split(" ");
        int n = pattern.length();
        if(n!=strs.length) return false;
        
        for(int i=0; i<n;i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(strs[i])) return false;
            }
            else{
                if(map2.containsKey(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
                map2.put(strs[i], pattern.charAt(i));
            }
        }
        
        return true;
        
    }
}
