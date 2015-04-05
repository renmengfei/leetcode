public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int x = 0, y = 0;
        
        while(m>0 && n>0){
            
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }
            
            // left to right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y++]);
            }
            
            //top to bottom
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }
            // right to left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
            
            // bottom to top
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
            
            m-=2;
            n-=2;
            x++;
            y++;
        }
        
        return result;
    }
}
