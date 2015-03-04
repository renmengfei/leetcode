// O(logN) binary search
public class Solution {
    public int findPeakElement(int[] num) {
        int start=0;
        int end=num.length-1;
        
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
            if(num[mid]>num[mid+1]){
                end = mid;
            }
            else start=mid+1;
        }
        return start;
    }
}
