class TrieNode {
    boolean isWordEnd;
    HashMap<Character,TrieNode> children ;
    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<Character,TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null || word.isEmpty()) return;
        char[] cs = word.toCharArray();
        int level = 0;
        TrieNode ptr = root;
        while(level!=cs.length){
            if(!ptr.children.containsKey(cs[level])){
                TrieNode tmp = new TrieNode();
                ptr.children.put(cs[level],tmp);
            }
            ptr = ptr.children.get(cs[level]);
            level++;
        }
        ptr.isWordEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ptr = root;
        char[] cs = word.toCharArray();
        int level = 0;
        
        while(level!=cs.length){
            if(!ptr.children.containsKey(cs[level])){
                return false;
            }
            else{
                ptr = ptr.children.get(cs[level]);
                level++;
            }
        }
        return ptr.isWordEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        char[] cs = prefix.toCharArray();
        int level = 0;
        
        while(level!=cs.length){
            if(!ptr.children.containsKey(cs[level])){
                return false;
            }
            else{
                ptr = ptr.children.get(cs[level]);
                level++;
            }
        }
        return true;
    }
}
