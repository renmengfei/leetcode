// Method 1: O(N^3)和3-sum思路一样
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Arrays.sort(num);
        for(int one=0;one<num.length-3;one++){
            //skip same one
            if(one==0 || num[one]!=num[one-1]){
                for(int two = one+1; two<num.length-2;two++){
                    //skip same two
                    if(two==one+1 || num[two]!=num[two-1]){
                        int three = two+1;
                        int four = num.length-1;
                        int sum1 = target-num[one]-num[two];
                        while(three<four){
                            int sum2 = num[three]+num[four];
                            if(sum1==sum2){
                                result.add(Arrays.asList(num[one],num[two],num[three],num[four]));
                                while(three<four && num[three]==num[three+1]) three++;
                                while(three<four && num[four]==num[four-1]) four--;
                                three++;
                                four--;
                            }
                            else if(sum1>sum2) three++;
                            else four--;
                        }
                    }
                }
            }
        }
        return result;
    }
}


// Method 2: O(N^2logN), 使用treemap
public class Solution {
    
    public static class Pair {
        int a;
        int b;
        int aIndex;
        int bIndex;
        public Pair(int aInput, int aIndexInput, int bInput, int bIndexInput) {
            a = aInput;
            aIndex = aIndexInput;
            b = bInput;
            bIndex = bIndexInput;
        }

        public boolean same(Pair p) {
            return p != null && p.a == a && p.b == b;
        }
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
       List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 4) {
            return result;
        }
        Arrays.sort(num);
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        
        // Build Map
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; ) {
                int sum = num[i]+num[j];
                List<Pair> list = new ArrayList<Pair>();
                if(map.containsKey(sum)){
                    list = map.get(sum);
                }
                else{
                    map.put(sum,list);
                }
                list.add(new Pair(num[i],i,num[j],j));
                // skip same j
                do{
                    j++;
                }while(j<num.length && num[j]==num[j-1]);
            }
        }
        
        // // Scan Map
        Integer low = map.firstKey();
        Integer high = map.lastKey();
        
        while(low!=null && high!=null && low<=high){
             if (low + high < target) {
                low = map.higherKey(low);
             } else if (low + high > target) {
                high = map.lowerKey(high);
             }else{
                // conbine pairs
                Pair lastA = null;
                for(Pair a: map.get(low)){
                    if(a.same(lastA)) continue;
                    lastA = a;
                    
                    Pair lastB=null;
                    for(Pair b: map.get(high)){
                        // no cross
                        if (a.bIndex < b.aIndex) {
                            if(b.same(lastB)) continue;
                            lastB = b;
                            
                            result.add(Arrays.asList(a.a, a.b, b.a, b.b));
                        }
                    }
                }
                low = map.higherKey(low);
                high = map.lowerKey(high);
            }
        }
        return result;
    }
}
