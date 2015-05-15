// Method 1:http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html
//思路其实跟jump game的dp做法很像，不是直接算dp[i]的关系，而是找出之前的所有dp[j]
public class Solution {
    public int minCut(String s) {
         int len = s.length();  
         int[] D = new int[len+1];  
         boolean[][] P = new boolean[len][len];  
        
        // init, the worst case is cutting by each char  
         for(int i = 0; i <= len; i++){
             D[i] = len-i;
         }
           
         //从后向前    
         for(int i = len-1; i >= 0; i--){  
             for(int j = i; j < len; j++){  
                 // bug:先计算j－i,短路，否则p会out of array boundary
                 if(s.charAt(i) == s.charAt(j) && (j-i<2 || P[i+1][j-1])){  
                       P[i][j] = true;  
                       D[i] = Math.min(D[i],D[j+1]+1);  
                  }  
             }  
        }  
        return D[0]-1;  
    }
}


 

// Method 2: initial thought
// 虽然麻烦，但很直观
public class Solution {
       private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // DP, if, dp[i][i] is palindrome, then dp[i+1][j-1]也是
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] cut = new int[s.length() + 1];
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        //cut[i]前i个
        cut[0] = 0;
	// bug: index很容易错！
        for (int i = 1; i <= s.length(); i++) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE) {
                    cut[i] = Math.min(cut[i], cut[i - j] + 1);
                }
            }
        }
	// bug: result-1
        return cut[s.length()] - 1;
    }
}
