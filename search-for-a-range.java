public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = searchStart(A, target);
        int end = searchEnd(A,target);
        return new int[]{start, end};
    }
    
    public int searchStart(int[] A, int target){
        int start = 0;
        int end = A.length-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]==target){
                while(mid>0 && A[mid-1]==target) mid--;
                return mid;
            }
            if(A[mid]>target) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
    
    public int searchEnd(int[] A, int target){
        int start = 0;
        int end = A.length-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]==target){
                while(mid<end && A[mid+1]==target) mid++;
                return mid;
            }
            if(A[mid]>target) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
