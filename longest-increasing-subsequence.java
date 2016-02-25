// Method 1: initial thought, DP, O(N^2) time, O(N) space
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int n = nums.length;
        int result = 1;
        int[] dp = new int[n];
        
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        
       return result;
        
    }
}


//Method 2: sequence存的是一种solution
    public int lengthOfLIS(int[] nums) {
        List<Integer> sequence = new ArrayList();
        for(int n : nums) update(sequence, n);

        return sequence.size();
    }

    private void update(List<Integer> seq, int n)
    {
        if(seq.isEmpty() || seq.get(seq.size() - 1) < n) seq.add(n);
        else
        {
            seq.set(findFirstLargeEqual(seq, n), n);
        }
    }

    private int findFirstLargeEqual(List<Integer> seq, int target)
    {
        int lo = 0;
        int hi = seq.size() - 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(seq.get(mid) < target) lo = mid + 1;
            else if(seq.get(mid)==target) return mid;
            else hi=mid-1;
        }
        return lo;
    }

