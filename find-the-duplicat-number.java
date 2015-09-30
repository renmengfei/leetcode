//暴力法，O(N^2)。 两层循环，看nums[i]==nums[j]
// Method 1: binary search, O(NlogN)
public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        
        while(low<high){
            int mid = low + (high-low)/2;
            int count = 0;
            for(int num: nums){
                if(num<=mid) count++;
            }
            
            if(count<=mid) low = mid+1;
            else high = mid;
        }
        
        return low;
    }
}


// Method 2: 龟兔赛跑O(n)
//http://keithschwarz.com/interesting/code/?dir=find-duplicate
//(1)init很重要，要把n-1当做link head，因为 index=[0,n] value=[1,n]->[0,n-1]，value少一个，所以最后一个永远不会num[i]=i+1
//(2) slow, fast作为index，而不是value
//(3) 最后slow==fast，说明前一步的nums[prev_slow]==nums[prev_fast]
// slow = nums[prev_slow]-1
// 重复的value=nums[prev_slow]=nums[prev_fast] = current_slow + 1

public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = n-1, fast = n-1;
        
        while(true){
            slow = nums[slow]-1;
            fast = nums[nums[fast]-1]-1;
            if(slow==fast) break;
        }
        
        fast = n-1;
        while(true){
            slow = nums[slow]-1;
            fast = nums[fast]-1;
            if(slow==fast) return slow+1;
        }
    }
}

