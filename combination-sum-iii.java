//时间复杂度是O(N!)
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new  ArrayList<List<Integer>>();
        combine(result, new ArrayList<Integer>() ,k , n, 1);
        return result;
    }
    public void combine(List<List<Integer>> result, List<Integer> path, int k, int n, int start) {
        if (k == 0) {
            if (n == 0){
                result.add(new ArrayList<>(path));
            }
            return;
        }
	// 直接写i<10也是AC，i<=n/k不是很好理解, 时间复杂度稍微有区别
        for (int i = start; i <= n / k && i < 10; i++) {
            path.add(i);
            combine(result, path, k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
