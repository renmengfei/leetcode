//插入法，简洁，iteration
public class Solution {
   public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(num[0]);
        list.add(one);

        for(int i=1;i<num.length;i++){
           list = insert(list, num[i]);
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>>list, int num){
        ArrayList<ArrayList<Integer>> newlist = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<=list.get(i).size();j++){
                ArrayList<Integer> tmp = new ArrayList<Integer>(list.get(i));
                tmp.add(j,num);
                newlist.add(tmp);
            }
        }

        return newlist;
    }
}

// Method 2: 试用于几乎所有搜索题套路(recursion+backtracking)，适用于leetcode类似的很多题
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        helper(result, new ArrayList<Integer>(), nums);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> path, int[] num){
        if(path.size()==num.length){
            result.add(new ArrayList<Integer>(path));
        }
        
        for(int i=0;i<num.length;i++){
            if(path.contains(num[i])) continue;
            path.add(num[i]);
            helper(result,path,num);
            path.remove(path.size()-1);
        }
    }
}
