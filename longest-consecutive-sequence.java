public class Solution {
    public int longestConsecutive(int[] num) {
      int res = 0;
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int n : num) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            int sum = left + right + 1;
            map.put(n, sum);

            res = Math.max(res, sum);

            if(left!=0) map.put(n - left, sum);
            if(right!=0) map.put(n + right, sum);
        }
        else {
            continue;
        }
    }
    return res;
    }
}
