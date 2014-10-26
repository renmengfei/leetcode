public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int level = 0;
        int lastlevel= n-level-1;
        while(level<lastlevel){
            for(int i=level;i<lastlevel;i++){
                int tmp = matrix[level][i];
                matrix[level][i]=matrix[n-i-1][level];
                matrix[n-i-1][level]=matrix[lastlevel][n-i-1];
                matrix[lastlevel][n-i-1]=matrix[i][lastlevel];
                matrix[i][lastlevel]=tmp;
                
            }
            level++;
            lastlevel--;
        }
    }
}

