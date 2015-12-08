// Method 1: initial thought DP
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        
        int[] dp = new int[n];
        dp[0]=k;
        dp[1]=k*k;
        
        for(int i=2;i<n;i++){
            dp[i]= dp[i-1]*(k-1) +dp[i-2]*(k-1);
        }
        
        return dp[n-1];
    
    }
}

// Method 2: optimize DP, constance space
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        
        int first=k;
        int second = k*k;
        
        
        for(int i=2;i<n;i++){
            int tmp = second*(k-1) + first*(k-1);
            first = second;
            second =tmp;
        }
        
        return second;
    
    }
}
