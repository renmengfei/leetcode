public class Solution {
    public int[][] generateMatrix(int n) {
        //和旋转矩阵 in place一样
        int start = 0;
        int end = n-1;
        int[][] result = new int[n][n];
        int num = 1;
        while(start<end){//和rotate matrix一样，不加等号，但是最后要处理等号！！
            //top
            for(int i = start;i<end;i++){
                result[start][i]=num;
                num++;
            }
            // right
            for(int i = start;i<end;i++){
                result[i][end]=num;
                num++;
            }
            //bottom
            for(int i=end;i>start;i--){
                result[end][i]=num;
                num++;
            }
            //left
            for(int i=end;i>start;i--){
                result[i][start]=num;
                num++;
            }
            start++;
            end--;
        }
        // bug: center has 1 pixel
        if(start==end){
            result[start][start] = num;
        }
        return result;
    }
}
