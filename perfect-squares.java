// DP
// dp[0]=0
// dp[1] = dp[1-1*1]+1 = 1
// dp[2] = dp[2-1*1]+1 =2
// dp[3] = dp[3-1*1]+1 =3
// dp[4] = Math.min(dp[4-1*1], dp[4-2*2] )+1 = 1

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i=1;i<=n;i++){
            for(int j=1; j*j <=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        
        return dp[n];
    }
}
