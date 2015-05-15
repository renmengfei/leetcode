public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if ((n+m)!=s3.length()) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        
	// init 
        dp[0][0] = true;
        for(int i=1;i<n+1;i++){
  	    // bug: 第i个位置，char的index是i－1
            dp[0][i]=dp[0][i-1] && (s1.charAt(i-1)==s3.charAt(i-1));
        }
        
        for(int i=1;i<m+1;i++){
            dp[i][0]=dp[i-1][0] && (s2.charAt(i-1)==s3.charAt(i-1));
        }
       
 	// start loop 
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = (dp[i-1][j] && (s2.charAt(i-1))==s3.charAt(i+j-1) ) || (dp[i][j-1] && (s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
        
        return dp[m][n];
    }
}
