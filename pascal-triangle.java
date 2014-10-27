public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows<1) return result;
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(1);
        result.add(item);
        
         for(int i=1;i<numRows;i++){
                List<Integer> last = result.get(i-1);
                List<Integer> current = new ArrayList<Integer>();
                current.add(1);

                for(int j=0;j<last.size()-1;j++){
                    int tmp =last.get(j)+last.get(j+1);
                    current.add(tmp);
                }
                current.add(1);
                result.add(current);
            }
        
        return result;
    }
    
}
