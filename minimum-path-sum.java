public class Solution {
    //O(n*m)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}

// No extra space
public int minPathSum(int[][] grid) {
    int m = grid.length;// row
    int n = grid[0].length; // column
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j != 0) {
                grid[i][j] = grid[i][j] + grid[i][j - 1];
            } else if (i != 0 && j == 0) {
                grid[i][j] = grid[i][j] + grid[i - 1][j];
            } else if (i == 0 && j == 0) {
                grid[i][j] = grid[i][j];
            } else {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                        + grid[i][j];
            }
        }
    }

    return grid[m - 1][n - 1];
}
