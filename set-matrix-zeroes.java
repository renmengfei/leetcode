public class Solution {
    public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //常数空间的话，
        //(1)第一可以考虑是不是固定数量的几个变量能搞定；
        //(2)可以考虑是不是问题本身已经提供了足够的空间
        
        //用第一行第一列来记录，这样就免去了 O(m+n) space
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows==0) return;
        // step 1:看第一行第一列是否有0，记录下来。不然用作storage后，自身的属性没有了
        for(int i=0;i<rows;i++){
            if(matrix[i][0]==0) {
                firstColZero = true;
                break;
            }
        }
        
         for(int i=0;i<cols;i++){
            if(matrix[0][i]==0) {
                firstRowZero = true;
                break;
            }
        }
        // step 2:找0， 记录
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        // step 3: turn to 0
        for(int i=1;i<rows;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<cols;j++){
                    matrix[i][j]=0;
                }
            }
        }
        
        for(int i=1;i<cols;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<rows;j++){
                    matrix[j][i]=0;
                }
            }
        }
        
        // step 4: set first col, row
        if(firstRowZero){
            for(int i=0;i<cols;i++){
                matrix[0][i]=0;
            }
        }
        
        if(firstColZero){
            for(int i=0;i<rows;i++){
                matrix[i][0]=0;
            }
        }
    }
}
