// Method 3: 算法模板，适用于combination，subset等题目
 public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, nums, 0);
	return result;
    }


  //我自己的做法，感觉更好理解
  public void helper(List<List<Integer>> result, List<Integer> path, int[] num, int pos){
        if(pos == num.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        List<Integer> tmp = new ArrayList<Integer>(path);
        tmp.add(num[pos]);
        helper(result, tmp, num, pos+1);
        helper(result, path, num, pos+1);

    }

    public void helper(List<List<Integer>> result, List<Integer> list, int[] num, int pos){
        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < num.length; i++) {

            list.add(num[i]);
            helper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }

    }

// Method 1: BFS插入法
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> empty = new ArrayList<Integer>();
		result.add(empty);
		
		for(int i=0;i<S.length;i++){
			int oldsize=result.size();
			for(int j=0;j<oldsize;j++){
			    List<Integer> next = new ArrayList<Integer>(result.get(j));
			    next.add(S[i]);
			    result.add(next);
			}
		}
		return result;
    }
}

// Method 2: bit pow(2, N),有或者没有
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = S.length;
		
		for(int i=0;i<Math.pow(2,n);i++){
		    result.add(bit(i,S));
		}
		return result;
    }
    
    public List<Integer> bit(int mask, int[] S){
        List<Integer> result = new ArrayList<Integer>();
        
        int digit = 0;
        for(int i=0;i<S.length;i++){
            int bit = mask&1;
            mask=mask>>1;
            if(bit==1) result.add(S[i]);
        }
        return result;
    }
}


