// test case没有cover， candidates有重复的情况，如果有重复，一定要先去重，或者在remove后，while(i==i+1）i++跳过重复
public class Solution {
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
        if(target==0){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                cur.add(candidates[i]);
                combine(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);//backtracking
            }
        }
    }
}
