/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */


// O(n) time, O(1) space
public class Solution {
    public int singleNumber(int[] A) {
        int ret = 0;
        for(int i:A){
            ret^=i;
        }
        return ret;
    }
}
