public class Solution {
    public boolean search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return search(A, 0, A.length-1, target);
    }

    public boolean search(int[] A, int left, int right, int target){
        if(right<left) return false;
        int mid = (left+right)/2;
        if(A[mid]==target) return true;

        //mess on right
        if(A[left]<A[mid]){
            if(target>=A[left] && target < A[mid])
                return search(A, left, mid-1, target);
            else return search(A, mid+1, right, target);
        }
        //mess on left
        else if(A[left]>A[mid]){
            if(target>A[mid] && target<=A[right])
                return search(A, mid+1, right, target);
            else return search(A, left, mid-1, target);
        }
        // 方法一：复杂，但O(logn)
        else{
            //A[left]==A[mid]
            if(A[left] > A[right]){
                if(target<A[mid]) return search (A, mid+1, right, target);
                else return false;
            }
            else if(A[left] < A[right]){
                if(target>A[mid]) return search(A,mid+1,right,target);
                else return false;
            }
            else{
                return search(A, left+1, mid-1, target)||search(A, mid+1, right-1, target);
            }

        }
        // 方法二： worst case all duplicates, and O(N)
	//else return search(A, left+1, right, target);
    }
}
