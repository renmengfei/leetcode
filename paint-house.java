// Method 1: dp[i][j]表示到ith house，用颜料j，最小cost
public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        
        dp[0][0]=costs[0][0];
        dp[0][1]=costs[0][1];
        dp[0][2]=costs[0][2];
        
        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+costs[i][2];
        }
        
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}

// Method 2: 简化，no space
// rr, gg, bb表示之前的value
public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        int n = costs.length;
        
        int r = 0, g = 0, b = 0;
        for (int i = 0; i < n; i++) {
            int rr = r, bb = b, gg = g; 
            r = costs[i][0] + Math.min(bb, gg);
            b = costs[i][1] + Math.min(rr, gg);
            g = costs[i][2] + Math.min(rr, bb);
        }
        return Math.min(r, Math.min(b, g));
        
    }
}
