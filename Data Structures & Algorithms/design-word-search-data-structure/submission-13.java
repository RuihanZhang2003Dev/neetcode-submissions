class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
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
            if (!cur.children.containsKey(word.charAt(i))) {
                cur.children.put(word.charAt(i), new TrieNode());
            }
            cur = cur.children.get(word.charAt(i));
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
                for (Character tmpc : cur.children.keySet()) {
                    if (searchWithRoot(word, i + 1, cur.children.get(tmpc))){
                        return true;
                    }
                }
                return false;
            }   
            else {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.endOfWord;

    }
}
