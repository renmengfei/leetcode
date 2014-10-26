// DP, 1-dimension cache
public class Solution {
    public int uniquePaths(int m, int n) {
       int[] dp = new int[n];
       dp[0]=1;
       for(int i=0;i<m;i++){
           for(int j=1;j<n;j++){
               dp[j]=dp[j-1]+dp[j];
           }
       }
       return dp[n-1];
    }
}
