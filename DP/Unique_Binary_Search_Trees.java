/*
  Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
*/

public class Solution {
    // method 1: recursively O(N^2)
    // public int numTrees(int n) {
        
    //     if(n<=1) return 1;
    //     int re = 0;
    //     for(int root=1;root<=n;root++){
    //         int left = numTrees(root-1);
    //         int right = numTrees(n-root);
    //         re+=left*right;
    //     }
    //     return re;
    // }
    
    // method 2: 1-D DP. method one has a lot of duplicate calculation, like fibonacci
    // Catalan, don't know the O()?
    public int numTrees(int n){
        if(n<1) return 1;
        int[] count = new int[n+1];
        count[0]=1;
        count[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                count[i]+=count[i-j]*count[j-1];
            }
        }
        return count[n];
    }
}
