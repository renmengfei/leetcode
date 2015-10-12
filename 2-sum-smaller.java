Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

//难点，指针在前面移动，sort后，不用每个都算sum，之间的已经满足条件了
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        
        int count = 0;
        Arrays.sort(nums);
        for(int three=2; three<len; three++){
            int one = 0;
            int two = three-1;
            
            while(one<two){
                int sum = nums[one]+nums[two]+nums[three];
                if(sum<target){
                   count += two-one;
                   one++;
               }
               else two--;
            }
        }
        return count;
    }
}
