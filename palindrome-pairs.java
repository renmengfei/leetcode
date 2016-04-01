// Method 1:理解上很简单
// 把一个string split to left+right，如果left是palindrom，那么把当前的string作为后半段。
// 如果right是palindrome，那么把当前string作为前半段
// O(N*K^2)
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> res = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) return result;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<words.length; i++) map.put(words[i],i);
        
        for(int i=0;i<words.length; i++){
            String word = words[i];
            for(int j=0;j<=word.length();j++){
                String left = word.substring(0,j);
                String right = word.substring(j);
                
                if(isPalindrome(left)){
                    String reverse = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reverse) && map.get(reverse)!=i){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(map.get(reverse));
                        tmp.add(i);
                        res.add(tmp);
                    }
                    
                }
                
                if(isPalindrome(right)){
                    String reverse = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(reverse) && map.get(reverse)!=i){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(map.get(reverse));
                        res.add(tmp);
                    }
                }
            }
        }
        
        for(List<Integer> list: res){
            result.add(list);
        }
        return result;
    }
    
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}

// reverse string 成成trie

public class Solution {
    class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;
    
        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
    
        TrieNode root = new TrieNode();
    
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
    
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
    
        return res;
    }
    
    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            if (root.next[word.charAt(i) - 'a'] == null) {
                root.next[word.charAt(i) - 'a'] = new TrieNode();
            }
    
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }
    
            root = root.next[word.charAt(i) - 'a'];
        }
    
        root.list.add(index);
        root.index = index;
    }
    
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
        for (int j = 0; j < words[i].length(); j++) {   
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                list.add(Arrays.asList(i, root.index));
            }
    
            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
    
        for (int j : root.list) {
            if (i == j) continue;
            list.add(Arrays.asList(i, j));
        }
    }
    
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
    
        return true;
    }
}
