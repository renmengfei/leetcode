// Method 1: initial thought, O(K) space
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
		k = k%len;
		
		int[] tmp = new int[k];
		for(int i=len-k;i<len;i++){
			tmp[i-len+k]=nums[i];
		}
		
		for(int i=len-k-1;i>=0;i--){
			nums[i+k]=nums[i];
		}
		
		for(int i=0;i<k;i++){
			nums[i]=tmp[i];
		}
    }
}

//Method 2: O(1) space
// 3 time reverse
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
       
    }
    
    public void reverse(int[] num, int start, int end){
        while(start<end){
            int tmp = num[start];
            num[start]=num[end];
            num[end]=tmp;
            start++;
            end--;
        }
    }
}
