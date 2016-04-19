// Method 1: DP
//思路其实跟jump game的dp做法很像，不是直接算dp[i]的关系，而是找出之前的所有dp[j]
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] pal = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (j+1>i-1 || pal[j+1][i-1])){
                    pal[j][i]=true;
                    // bug: j==0前面没有dp，这时不用切割，min=0
                    min = j==0? 0: Math.min(min, dp[j-1]+1);
                }
            }
            dp[i] = min;
        }
        
        return dp[n-1];
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
