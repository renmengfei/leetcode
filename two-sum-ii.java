// two pointers O(N)
// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
		int start = 0;
		int end = numbers.length-1;
		while(start<end){
			int sum = numbers[start]+numbers[end];
			if(sum==target){
				result[0]=start+1;
				result[1]=end+1;
				return result;
			}
			if(sum<target) start++;
			else end--;
		}
		return result;
    }
}
