public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(result, new ArrayList<Integer>(), num, target, 0);
        return result;
    }
    
    public void combine(List<List<Integer>> result, List<Integer> cur, int[] num, int target, int start){
        if(target==0){
            result.add(new ArrayList<Integer>(cur));
        }
        else if(target>0){
            for(int i= start; i < num.length; i++){
                cur.add(num[i]);
                combine(result, cur, num, target - num[i], i+1);
                cur.remove(cur.size()-1);
 		// 去除重复，               
                while(i<num.length-1 && num[i]==num[i+1]) i++;
                
            }
        }
        
    }
}
