public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        //method 1: O(n+m)线性查找
        // int col = n-1;
        // int row = 0;
        // while(row<m && col>=0){
        //     if(matrix[row][col]==target) return true;
        //     if(matrix[row][col]>target) col--;
        //     else row++;
        // }

        // return false;


        //method2: O(lg(n*m)) = O(lgn+lgm) binary search
        int low = 0;
        int high = m*n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid/n][mid%n]==target) return true;
            if(matrix[mid/n][mid%n]<target) low = mid+1;
            else high=mid-1;
        }
        return false;
    }
}
