// DP, O(N) space, O(MN) time
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col+1];
        if(obstacleGrid[0][0]==1) return 0;
        
        dp[1]=1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[j+1]= obstacleGrid[i][j]==1?0:dp[j+1]+dp[j];
            }
        }
        return dp[col];
    }
}
