public class Solution {
    //O(N)
    public int searchInsert(int[] A, int target) {
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
	return start;
    }
}
