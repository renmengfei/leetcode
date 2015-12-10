//p[i][j] represents the min paint cost from house 0 to house i when house i use color j; The formula will be dp[i][j] = Math.min(any k!= j| dp[i-1][k]) + costs[i][j].

Take a closer look at the formula, we don't need an array to represent dp[i][j], we only need to know the min cost to the previous house of any color and if the color j is used on previous house to get prev min cost, use the second min cost that are not using color j on the previous house

// 只需要3个变量，min1, min2, min1的颜色号

public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = 0, min2 = 0, idMin1 = -1;
    
        for(int i = 0; i < n; i++) {
            int m1 = Integer.MAX_VALUE, m2 = m1, idm1 = -1;
    
            for(int j = 0; j < k; j++) {
                // If same color as j - 1, we can only extend from 2nd min of j - 1
                int cost = costs[i][j] + (j == idMin1 ? min2 : min1);
    
                // Update m1 m2 if cost is smaller than any of them
                if(cost < m1) {               
                    m2 = m1; m1 = cost; idm1 = j;
                } else if(cost < m2) {        
                    m2 = cost;
                }
            }
            min1 = m1; idMin1 = idm1; min2 = m2; 
        }
        return min1;   
    }
}
