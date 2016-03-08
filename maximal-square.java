// Method 1: initial thought

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        
        int rows = matrix.length;
        if(rows==0) return 0;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        
        // init
        for(int i=0;i<rows; i++){
            dp[i][0]=matrix[i][0]-'0';
            result = Math.max(result, dp[i][0]);
        }
        
        for(int i=0;i<cols; i++){
            dp[0][i] = matrix[0][i]-'0';
            result = Math.max(result, dp[0][i]);
        }
        
        
        for(int i=1; i<rows; i++){
            for(int j=1;j<cols; j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        
        return result*result;
        
    }
}


// Method 2: 简化版
// DP[i][j]代表edge
public class Solution {
    public int maximalSquare(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
            
        }
}


