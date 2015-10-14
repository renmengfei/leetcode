//就是fibonacci数列
// Method 1: O(N) space
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

// Method 2: o(1) space
    public int climbStairs(int n) {
        if(n<=1) return n;
        int last = 1;
        int lastlast=1;
        int cur = 0;
        for(int i=2;i<=n;i++){
            cur = last+lastlast;
            lastlast = last;
            last=cur;
        }
        return cur;
       
    }
