class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfWord = false;
    }
}

// it is the same logic than the prefix tree


class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i< word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        /*
        idea: there are at most 2 dots in the query, so at most 26 * 26 look up for 
        2 dots, and 2 for loops, so no need to worry of search. if there is a dot, get 
        all the children from current node, pass it down as root and search if one of
        them returns true.
        */
        return searchWithRoot(word, 0, root);
    }

    // helper for search with dots
    private boolean searchWithRoot(String word, int j, TrieNode root) {
        TrieNode cur = root;
        
        for (int i = j; i< word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && searchWithRoot(word, i + 1, child)){
                        return true;
                    }
                }
                return false;
            }   
            else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.endOfWord;

    }
}
