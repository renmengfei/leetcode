/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/

//寻找interval
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int pre = lower - 1;
        
        // <=注意最后一个不能丢
        for(int i = 0 ; i <= A.length  ; i++){
            int cur = i == A.length ? upper + 1 : A[i]; 
            if(pre + 2 == cur){
                result.add(String.valueOf(pre + 1));
                
            }else if(pre + 2 < cur){
                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(cur - 1));
            }
            pre = cur;
        }
        return result;
        
    }
}

