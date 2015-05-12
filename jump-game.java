//  greedy, O(n) time, O(1) space
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

// Method 2: time limit exceed. 不是最优，但是sequence DP思路
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0]=true;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && i<=j+nums[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
