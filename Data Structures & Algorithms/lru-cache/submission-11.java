class Node {
    // costom node class
    Node left;
    Node right;
    int key;
    int value;

    public Node(){}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    /*
    idea: use doubly linked list as cache, renewing usage would remove and re insert to the right
    when needing to pop, we will pop from left. and use a hashmap to store the cache
    */
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

    // private helper for insertion and removal of node in doubly linked list
    // insert would be at the end of the list, and if the key already exists, remove it and put it
    // to the back
    private void insert(Node n) {
        Node left = rightDum.left;
        left.right = n;
        n.left = left;
        rightDum.left = n;
        n.right = rightDum;
    }
    // remove lRU
    private int removeLRU() {
        Node removed = leftDum.right;
        leftDum.right = leftDum.right.right;
        leftDum.right.left = leftDum;
        return removed.key;
    }
    // remove would remove the one with the right key, since node itself is in the doubly linked 
    // list (has left and right as field) and cache can direct the map to the node itself with key,
    // all we have to do is detach, O(1)
    private Node remove(int key) {
        Node cur = cache.get(key);
        Node curLeft = cur.left;
        Node curRight = cur.right;
        curLeft.right = curRight;
        curRight.left = curLeft;
        cur.left = null;
        cur.right = null;
        return cur;
    }
    
    
    public int get(int key) {
        // if current cache doesnt have the key, return -1
        if (!cache.containsKey(key)) return -1;
        // otherwise remove from linked list and reinsert
        Node n = remove(key);
        insert(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        // if cache has no key, create new node and put it in the list
        if (!cache.containsKey(key)) {
            Node n = new Node(key, value);
            cache.put(key, n);
            insert(n);
            // if exceeds capacity, remove lru
            if (cache.size() > cap) {
                int removed_key = removeLRU();
                cache.remove(removed_key);
            }
        }
        // otherwise just update value and remove and reinsert
        else {
            Node n = remove(key);
            n.value = value;
            insert(n);
        }
    }
}
