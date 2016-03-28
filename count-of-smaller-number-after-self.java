// longest increasing sequence类似
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findFirstLargeEqual(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }
    
    private int findFirstLargeEqual(List<Integer> seq, int target)
    {
        if (seq.size() == 0) return 0;
        int lo = 0;
        int hi = seq.size() - 1;
        
        if (seq.get(hi) < target) return hi + 1;
        if (seq.get(lo) >= target) return 0;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(seq.get(mid) < target) lo = mid + 1;
            else if(seq.get(mid)==target){
                while(seq.get(mid-1)==target) mid--;
                return mid;
            }
            else hi=mid-1;
        }
        return lo;
    }
}
