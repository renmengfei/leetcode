// Method 1: 模板题
// The idea to resolve duplicate is to ensure that for elements with the same value, we make sure that they are picked up in the ascending order of index. 
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(result, new ArrayList<Integer>(), nums, visited);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] visited){
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
                    return;
                }
                visited[i] = true;
                path.add(nums[i]);
                helper(result, path, nums, visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }
}

// Method 2: 参考next permutation
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        int n = num.length;
        Arrays.sort(num);

        result.add(asList(num));
        
        while(true){
            int i;
            for(i=n-1;i>0;i--){
                if(num[i]>num[i-1]) break;
            }
            if(i==0) break;//get the largest permutation
            int j;
            for(j=n-1; j>i-1;j--){
                if(num[j]>num[i-1]) break;
            }
            swap(num,j,i-1);
            reverse(num, i, n-1);
            result.add(asList(num));
        }
        return result;
    }
    
    public List<Integer> asList(int[] num){
        List<Integer> result = new ArrayList<Integer>();
        for (int index = 0; index < num.length; index++) result.add(num[index]);
        return result;
    }
    
     public void reverse(int[] num, int start, int end){
       while(start<end){
            swap(num,start++,end--);
        }
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}

