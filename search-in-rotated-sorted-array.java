//Binary search
//O(logn)
//注意等号问题！根据[3,1]，偶数个元素来想等号
//只有两种情况
------------
A[mid]>A[start]
// 0 1 2 3 4
// 1 2 3 4 0
// 2 3 4 0 1
--------------
A[mid]<A[start]
// 3 4 0 1 2
// 4 0 1 2 3

public class Solution {
    public int search(int[] A, int target) {
        return search(A, target,0,A.length-1);
    }
    
    public int search(int[] A, int target, int start, int end){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(A[mid]==target) return mid;
        // left is sorted
        if(A[mid]>=A[start]){
            if(target<A[mid] && target>=A[start])
                return search(A,target,start, mid-1);
            else return search(A, target,mid+1,end);
        }
	// right is sorted
        else{
            if(target>A[mid] && target<=A[end])
                return search(A,target,mid+1,end);
            else return search(A,target, start,mid-1);
            
        }
    }
}
