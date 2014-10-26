// Assume No Duplicates
public class Solution {
    public int findMin(int[] num) {
        return find(num,0,num.length-1);
    }
    
    public int find(int[]A, int start, int end){
        if(start==end) return A[start];
        int mid=(start+end)/2;
        // Normal case, no shuffle
        if(A[start]<A[end]){
            return A[start];
        }
        
        //bug: >=,  mid+1 are important for case [2,1]
        else if(A[mid]>=A[start]){
            return find(A,mid+1,end);
        }
        else
            return find(A,start,mid);
        
    }
}


