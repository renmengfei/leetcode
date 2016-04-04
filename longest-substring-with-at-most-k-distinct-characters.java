// 跟at most 2一模一样
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int result = 0;

        if(k==0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(( map.size()==k && !map.containsKey(c))){
                int min = s.length();
                for(char tmp: map.keySet()) {
                    min = Math.min(map.get(tmp),min);
                }
                char removec = s.charAt(min);
                map.remove(removec);
                start = min+1;
            }
            map.put(c,i);
            result = Math.max(result, i-start+1);
        }

        return result;
    }
}
