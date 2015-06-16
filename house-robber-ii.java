public class Solution {
    //奇偶性
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    // house rob 1 稍微变形
    public int rob(int[] nums, int start, int end){
        int a = 0, b = 0;
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }
        return Math.max(a, b);
    }
}
