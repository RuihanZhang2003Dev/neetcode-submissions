class TrieNode {
    // no need to have actual values in the node as we use the Character as
    // key to store the children nodes.
    HashMap<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode(){
        this.children = new HashMap<>();
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
            // if it does not exist, put it in the hashmap, otherwise
            // just move to the node that correspond to character c
            if (!cur.children.containsKey(word.charAt(i))) {
                TrieNode node = new TrieNode();
                cur.children.put(word.charAt(i), node);
            }
            cur = cur.children.get(word.charAt(i));
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i< word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                return false;
            }
            cur = cur.children.get(word.charAt(i));
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i< prefix.length(); i++) {
            if (!cur.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            cur = cur.children.get(prefix.charAt(i));
        }
        return true;

    }
}
