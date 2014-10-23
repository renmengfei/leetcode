public class Solution {
    //O(N) overwrite
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len==0) return 0;
        if(len==1) return 1;
        
        int end=1;
        int pivot=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]!=pivot) {
                A[end++]=A[i];
                pivot=A[i];
            }
        }
        
        return end;
    }
}
