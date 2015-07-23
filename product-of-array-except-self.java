// trapping rain water是一种题。
//既然不能用除法， 那么只能算一下左边，再算一下右边
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int tmp =1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp =1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
