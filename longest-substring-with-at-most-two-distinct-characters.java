/**
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/


// The key is to store the last occurrence of each character as the value in the hashmap. This way, whenever the size of the hashmap exceeds 2, we can traverse through the map to find the character with the left most index, and remove 1 character from our map.
// 用hashmap可以拓展到k distinct
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int result = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(( map.size()==2 && !map.containsKey(c)) || map.size()>2){
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
