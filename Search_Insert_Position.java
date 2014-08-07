/*
* Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
* No duplicate numbers
*/

public class Solution {
    //O(N)
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(target<A[0]) return 0;
        if(target>A[A.length-1]) return A.length;

        int start = 0;
        int end = A.length-1;
        int mid=0;

        while(start<=end)
        {
            mid = (start+end)/2;
            if(A[mid]==target) return mid;
            if(A[mid]<target) start = mid+1;
            else end = mid-1;
        }
        if(A[mid]>target) return mid;
        else return mid+1;
    }
}
