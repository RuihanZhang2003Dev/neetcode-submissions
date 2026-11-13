class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        endOfWord = false;
    }
}


class WordDictionary {
    // idea: make Trie, and when search for the word and encounter dot, just check all 26 possibility
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c- 'a'] == null) cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        // idea: search normally until encounter dots, when encountering dots, we seach all the
        // children and in their children to find the word

        return find(word, 0, root);
    }

    private boolean find(String word, int ind, TrieNode root) {
        TrieNode cur = root;
        for (int i = ind; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child: cur.children) {
                    if (child != null && find(word, i +1, child)) return true;
                }
                return false;   // if none of the child matches, return false 
            }
            else {
                if (cur.children[c - 'a'] == null) return false;
                cur= cur.children[c - 'a'];
            }
        }
        return cur.endOfWord;
    }
}
















