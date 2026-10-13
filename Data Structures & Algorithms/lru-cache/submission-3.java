class LRUCache {
    /*
    idea: use a hashmap to store the LRU cache, use a doubly linkedList to store the usage of the 
    key, when they use that key through get, or put, remove the 
    */
    HashMap<Integer, Integer> cache;
    int cap;
    LinkedList<Integer> keyUsage;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cap = capacity;
        keyUsage = new LinkedList<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        // update the key usage
        keyUsage.removeFirstOccurrence(key);
        keyUsage.add(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        
        if (!cache.containsKey(key)) {
            if (cache.size() == cap) {
                cache.remove(keyUsage.poll());
            }
            cache.put(key, value);
            keyUsage.add(key);
        }
        else {
            keyUsage.removeFirstOccurrence(key);
            keyUsage.add(key);
            cache.put(key, value);
        }
        
    }
}
