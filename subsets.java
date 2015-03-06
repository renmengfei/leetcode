// Method 1: BFS
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
