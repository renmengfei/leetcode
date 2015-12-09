// Method 1: initial thought正常的矩阵乘法
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m=A.length, n=A[0].length, k=B[0].length;
        
        int[][] result = new int[m][k];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]!=0){
                    for(int t=0;t<k;t++){
                        if(B[j][t]!=0) result[i][t] += A[i][j]*B[j][t];
                    }
                }
            }
        }
        return result;
    }
}


