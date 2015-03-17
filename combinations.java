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
