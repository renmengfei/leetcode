//http://algobox.org/create-maximum-number/
//(1)Given one array of length n, create the maximum number of length k.
用stack

for(int i=0;i<N;i++){
   while(!s.isEmpty() && s.peek()<nums[i] && (N-i)+s.size()>=k) s.pop();
   s.push(nums[i]);
}

//(2)简化版2：Given two arrays n, m,  create the maximum number of length n+m
merge sort,唯一tricky的地方是，如果前面都相同，要选大的[6,7], [6,0,4]要选第一个6

//(3)list11 里找i个，list2里找(k-i)个，merge 后就是一个solution
i=[0,k] solution中最大的就是这道题的答案

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];   
        
       //注意i的范围，如果k大于m，那么m如果全选了，n中最少也得选k-m个，所以i的初始值这样写
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }
    
    // given 1 array with length N, find k
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
    
    // given 2 arrays with length N,M, find N+M
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    
    
}
