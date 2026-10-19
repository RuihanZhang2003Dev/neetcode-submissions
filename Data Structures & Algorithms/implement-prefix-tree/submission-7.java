class TrieNode {
    // no need to have actual values in the node as we use the Character as
    // index to store the children nodes.
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.endOfWord = false;
    }
}



class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        // go from character to character;
        TrieNode cur = root;
        for (int i = 0; i< word.length(); i++) {
            // if it does not exist, put it in the array, otherwise
            // just move to the node that correspond to character c
            int index = word.charAt(i) -'a';
            if (cur.children[index] == null) {
                TrieNode node = new TrieNode();
                cur.children[index] = node;
            }
            cur = cur.children[index];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i< word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i< prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;

    }
}
