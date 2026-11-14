class TrieNode {

    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c- 'a'] == null) cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        /*
        idea: use Trie tree to store dictionary, and then bottom up dp to find the extra character
        of string
        */

        Trie tree = new Trie();
        for (String str: dictionary) tree.addWord(str);
        

        int len = s.length();
        int[] res = new int[len+1];
        // result if no substring is found

        for (int i = len-1; i>= 0; i--) {
            res[i] = 1 + res[i + 1];    // initial result is if we skip the current char and go for 
            // the smallest extra char of the next char
            TrieNode cur = tree.root;

            for (int j = i; j < len; j++) {
                char c = s.charAt(j);
                if (cur.children[c - 'a']  == null) break;
                cur = cur.children[c - 'a'];
                if (cur.endOfWord) res[i] = Math.min(res[i], res[j + 1]);
            }
        }
        return res[0];
    }
}







