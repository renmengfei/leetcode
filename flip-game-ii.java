You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.

// Method 1: backtracking, O(2^N) exponential
public class Solution {
    public boolean canWin(String s) {
        int len = s.length();
        
        for(int i=0;i<len-1;i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                String tmp = s.substring(0,i)+"--"+s.substring(i+2);
                if(!canWin(tmp)) return true;
            }
        }
        return false;
    }
}

// Method 2: 发现跟fib数列一样，可以通过存储已走过的string组合而减少时间
public class Solution {
     public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        HashMap<String, Boolean> winMap = new HashMap<String, Boolean>();
        return helper(s, winMap);
    }

    public boolean helper(String s, HashMap<String, Boolean> winMap) {
        if (winMap.containsKey(s)) {
            return winMap.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i+2);
                if (!helper(t, winMap)) {
                    winMap.put(s, true);
                    return true;
                }
            }
        }
        winMap.put(s, false);
        return false;
    }
}

// Method 3: DP O(N^2)
