public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0, end = citations.length-1;
        int mid;
        // 等号很重要，对于[0],  [100] case
        while(start<=end){
            mid = start + (end-start)/2;
            if(citations[mid]>=n-mid){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        
        return n-start;
    }
    
    
}
