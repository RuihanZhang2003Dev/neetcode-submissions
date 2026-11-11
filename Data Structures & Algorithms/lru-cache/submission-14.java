// idea: create a custom node class to build doubly linked list for the lru cache
class Node {
    Node left;
    Node right;
    int key;
    int val;

    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class LRUCache {

    // use hash map as cache so that we can refer to the node in the lru linked list in O(1) 
    // will need insert and removal helper for doubly linked list
    Map<Integer, Node> cache;
    int cap;
    Node leftDum;
    Node rightDum;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cap = capacity;
        leftDum = new Node();
        rightDum = new Node();
        leftDum.right = rightDum;
        rightDum.left = leftDum;
    }

    // private helper
    // for insertion, we only have to insert to the right
    private void insert(Node n) {
        Node left = rightDum.left;
        left.right = n;
        n.left = left;
        n.right = rightDum;
        rightDum.left = n;
    }
    
    // removal of the lru from cache
    private int removeLRU() {
        Node removed = leftDum.right;
        leftDum.right = removed.right;
        removed.right.left = leftDum;
        removed.left = null;
        removed.right = null;
        return removed.key;
    }
    // for removal, we get it from the hashmap and remove it
    private Node remove(int key) {
        Node n = cache.get(key);
        Node curLeft = n.left;
        Node curRight = n.right;
        curLeft.right = curRight;
        curRight.left = curLeft;
        n.left = null;
        n.right = null;
        return n;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node n = remove(key);
        insert(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        // if the key does not exists, put it in cache and list, remove lru if needed
        if (!cache.containsKey(key)) {
            Node n = new Node(key, value);
            cache.put(key, n);
            insert(n);
            if (cache.size() > cap) {
                int removedKey = removeLRU();
                cache.remove(removedKey);
            }
        }
        else {
            Node n = new Node(key, value);
            remove(key);
            cache.put(key, n);
            insert(n);
        }
    }
}
