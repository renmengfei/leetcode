// Method 1:模板题
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        helper(result, new ArrayList<Integer>(), n, k, 1);
        return result; 
    }
    
    public void helper(List<List<Integer>> result, List<Integer> path, int n, int k, int start){
        if(path.size()==k){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i=start; i<=n; i++){
            path.add(i);
            helper(result, path, n, k, i+1);
            path.remove(path.size()-1);
        }
    }
}

// Method 2: math
public class Solution {
    //Cn(k)=Cn-1(k)+Cn-1(k-1)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<k) return result;
        
        if(k==1){
            for(int i=1;i<=n;i++){
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(i);
                result.add(item);
            }
            return result;
        }
        
        List<List<Integer>> subset1 = combine(n-1,k-1);
        List<List<Integer>> subset2 = combine(n-1,k);
        
        result.addAll(subset2);
        
        List<Integer> one;
        for(int i=0;i<subset1.size();i++){
            one = subset1.get(i);
            one.add(n);
            result.add(one);
        }
        return result;
        
    }
}
