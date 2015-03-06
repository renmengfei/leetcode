// Assume No Duplicates
public class Solution {
        // 0 1 2 3 4 (normal case)
        // 1 2 3 4 0 (mid >= start)
        // 2 3 4 0 1
        // 3 4 0 1 2 (mid < start)
        // 4 0 1 2 3
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
        // mess on right
        else if(A[mid]>=A[start]){
            return find(A,mid+1,end);
        }
	//mess on left
        else
            return find(A,start,mid);
        
    }
}


