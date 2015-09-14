// O(N) time, O(1) space
public class Solution {
    public int jump(int[] A) {
        int steps = 0;// step初始化是0
        int next = A[0];
        int cur = 0;
        
        for(int i=0;i<A.length;i++){
            if(i>cur){
                steps++;
                cur = next;
            }
	    // bug:next的更新顺序不能跟if调换，要先使用cur＝next，再更新next。否则step会少算
           // if没有跟else，这个m
            next = Math.max(next,A[i]+i);
        }
        return steps;
        
    }
}
