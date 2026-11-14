class TrieNode {
    TrieNode[] children;
    boolean end;

    public TrieNode() {
        children = new TrieNode[26];
        end = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String s) {
        TrieNode cur = root;
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.end =true;
    }
}


class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        // idea: implement tries and use bottom up dp to find the result
        int len = s.length();
        Trie tree = new Trie();
        TrieNode root = tree.root;
        for (String str: dictionary) tree.addWord(str);

        int[] res = new int[len +1];
        for (int i = len -1; i >= 0; i--) {
            res[i] = 1 + res[i+1];  // initial choice: skip char and include the minextra char of next
            TrieNode cur = root;
            // check if from current index we can form a word in dict
            for (int j = i; j < len; j++) {
                if (cur.children[s.charAt(j) - 'a'] == null) break;
                cur = cur.children[s.charAt(j) - 'a'];
                // if we can form a word from this char, check if by forming this word we reducing the
                // miin extra char
                if (cur.end) res[i] = Math.min(res[i], res[j + 1]);
            }
        }
        return res[0];
    }
}









