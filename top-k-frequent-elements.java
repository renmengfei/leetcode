// Method1: priority queue
// Method2: bucket sort
//巧妙之处，bucket的value是0-nums.length，表示count，是有限的
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n: nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        for(int key: freq.keySet()){
            int count = freq.get(key);
            if(bucket[count]==null){
                bucket[count] = new ArrayList<Integer>();
            }
            bucket[count].add(key);
        }
        
       List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                for(int candi: bucket[pos]){
                    res.add(candi);
                    if(res.size()==k) break;
                }
            }
        }
        return res;
    }
}
