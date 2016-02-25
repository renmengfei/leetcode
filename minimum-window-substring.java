//跟Minimum Size Subarray Sum思路一样
//两个指针，end先移动，满足条件后start再缩进
public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: t.toCharArray()){
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        
        int count=t.length();
        int start=0, end=0;
        int minLen = Integer.MAX_VALUE, head = 0;
        
        while(end<s.length()){
            char c1 = s.charAt(end++);
            if(map.containsKey(c1)){
                if(map.get(c1)>0) count--;
                map.put(c1, map.get(c1)-1);
            }
            
            while(count==0){
                if(end-start<minLen){
                        minLen = end-start;
                        head = start;
                }
                char c2 = s.charAt(start++);
                if(map.containsKey(c2)){
                   if(map.get(c2)==0) count++;
                   map.put(c2, map.get(c2)+1);
                }
            }
        }
        
        return minLen==Integer.MAX_VALUE?"": s.substring(head, head+minLen);
    }
}
