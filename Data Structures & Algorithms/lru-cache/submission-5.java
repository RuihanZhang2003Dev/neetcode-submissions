class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    /*
    idea: set my own class of linkedlist that tracks the lru as left and
    mru as right HashMap to store the cache, use a HashMap to access the 
    key, node pair
    */
    int cap;
    HashMap<Integer, Node> cache;
    // dummy nodes for LRU and MRU nodes
    Node left;
    Node right;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();  
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left; 
    }
    
    // helper function for doubly linked list
    // remove node from list
    public void remove(Node node) {
        Node prev= node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    // insert at right
    public void insert(Node node) {
        Node prev = right.prev;
        node.prev = prev;
        prev.next = node;
        right.prev = node;
        node.next = right;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {   
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);
        // check capacity
        if (cache.size() > cap) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }   
    }
}
