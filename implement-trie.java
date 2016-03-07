class TrieNode {
    // Initialize your data structure here.
    char val;
    TrieNode[] children;
    boolean eof;
    
    public TrieNode() {
        children = new TrieNode[26];
        eof = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode ptr = root;
        
        for(char c: word.toCharArray()){
            if(ptr.children[c-'a']==null){
                ptr.children[c-'a'] = new TrieNode();
                ptr.children[c-'a'].val = c;
            }
            ptr = ptr.children[c-'a'];
        }
        ptr.eof = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ptr = root;
        
        for(char c: word.toCharArray()){
            if(ptr.children[c-'a']==null) return false;
            ptr = ptr.children[c-'a'];
        }
        
        return ptr.eof;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        
        for(char c: prefix.toCharArray()){
            if(ptr.children[c-'a']==null) return false;
            ptr = ptr.children[c-'a'];
        }
        
        return true;
    }
}
