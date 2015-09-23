// Method 1: initial thought, recursion
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if (s1.equals(s2)) return true;
        if(!sort(s1).equals(sort(s2))) return false;
        
        for (int i=1; i<s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) 
             && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
             && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
    
    public String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

// DP
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if (s1.equals(s2)) return true;
       
        int n = s1.length();
        boolean[][][]dp = new boolean[n][n][n];
        
        // initial
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[0][i][j] = s1.charAt(i)==s2.charAt(j);
            }
        }
        
         for(int len = 2; len <= n; len++){
            for(int i = n - len; i>= 0; i--) {
                for(int j = n - len;  j>=0; j--){
                    boolean r = false;
                    for(int k = 1; k < len && r == false; k++){
                        r = (dp[k-1][i][j] && dp[len-k-1][i+k][j+k]) || (dp[k-1][i][j+len-k] && dp[len-k-1][i+k][j]);
                    }
                    dp[len-1][i][j]=r;
                }
            }
         }
        return dp[n-1][0][0];
    }
    
}
