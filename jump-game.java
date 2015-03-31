// O(n) time, O(1) space
public class Solution {
    public boolean canJump(int[] A) {
        int end = 0;
        for(int i=0; i<=end;i++){
            end = Math.max(end, A[i]+i);
            if(end>=A.length-1) return true;
        }
        return false;
    }
}
