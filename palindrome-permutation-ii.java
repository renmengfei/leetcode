// permutation-ii
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<String>();
        
        // check palindrome
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        boolean isvalid = isPalindrome(map, s);
        if(!isvalid) return result;
        
        String mid = "";
        List<Character> num = new ArrayList<Character>();
        for(char c: map.keySet()){
            int count = map.get(c);
            if(count%2!=0) mid += c;
            
            for(int i=0;i<count/2;i++){
                num.add(c);
            }
        }
        
        // permutation
        getPerm(result, num, new StringBuilder(), new boolean[num.size()], mid );
        return result;
    }
    
    public boolean isPalindrome(Map<Character, Integer> map, String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c, map.get(c)+1);
            
            if(map.get(c)%2==0) count-=1;
            else count+=1;
        }
        
        if(count>1) return false;
        return true;
    }
    
    public void getPerm(List<String> result, List<Character> nums, StringBuilder path, boolean[] visited, String mid) {
        if(path.length()==nums.size()){
            result.add(path.toString()+mid+path.reverse().toString());
            path.reverse();
            return;
        }
        
        for(int i=0;i<nums.size();i++){
            if(!visited[i]){
                if(i>0 && nums.get(i)==nums.get(i-1) && visited[i-1]) return;
                visited[i]=true;
                path.append(nums.get(i));
                getPerm(result, nums, path, visited, mid);
                path.deleteCharAt(path.length()-1);
                visited[i]=false;
            }
        }
    }
}
