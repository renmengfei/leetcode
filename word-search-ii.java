// 用trie做dfs
    Set<String> res = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, "", i, j, trie);
            }
        }
        return new ArrayList<String>(res);
    }
    
    public void dfs(char[][] board, String str, int x, int y, Trie trie){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (board[x][y]=='.') return;

        str+=board[x][y];
        if (!trie.startsWith(str)) return;
        if(trie.search(str)) res.add(str);
        
        char c = board[x][y];
        board[x][y]='.';
        dfs(board, str, x - 1, y, trie);
        dfs(board, str, x + 1, y, trie);
        dfs(board, str, x, y - 1, trie);
        dfs(board, str, x, y + 1, trie);
        board[x][y] = c;
    }
