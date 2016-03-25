// dfs+cache，防止多次访问，TLE
public class Solution {
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
    
        int result = 1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len = dfs(matrix, i, j, cache);
                result = Math.max(result, len);
            }
        }
        return result;
    }
    
    
    public int dfs(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j]!=0) return cache[i][j];
        
        int result = 1;
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length || matrix[x][y]<=matrix[i][j]) continue;
            
            result = Math.max(result, 1+dfs(matrix, x, y, cache));
        }
        cache[i][j]=result;
        return result;
    }
}
