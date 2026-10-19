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
        return searchWithRoot(word, root);
    }

    // helper for search with dots
    private boolean searchWithRoot(String word, TrieNode root) {
        TrieNode cur = root;
        boolean found = false;
        for (int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // if it is the last char in the search, check for end of word
                if (i == word.length() -1) {
                    for (Character tmpc : cur.children.keySet()) {
                        found = found ||
                        cur.children.get(tmpc).endOfWord;
                    }
                }
                // otherwise check for word
                else {
                    for (Character tmpc : cur.children.keySet()) {
                        found = found || 
                        searchWithRoot(word.substring(i+1), cur.children.get(tmpc));
                    }
                }
                
                return found;
            }
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.endOfWord;

    }
}
