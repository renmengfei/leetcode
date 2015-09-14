public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result= new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String s: strs){
            char[] cstr = s.toCharArray();
            Arrays.sort(cstr);
            String key = String.valueOf(cstr);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        
        for(String key: map.keySet()){
            List<String> group = map.get(key);
            Collections.sort(group);
            result.add(group);
        }
        return result;
    }
}
