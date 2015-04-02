// O(N) time, O(1) space
public class Solution {
    public int jump(int[] A) {
        int steps = 0;
        int maxlen = A[0];
        int next = 0;
        
        for(int i=0;i<A.length;i++){
            if(i>next){
                steps++;
                next = maxlen;
            }
            maxlen = Math.max(maxlen,A[i]+i);
        }
        return steps;
        
    }
}
