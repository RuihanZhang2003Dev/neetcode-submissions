class MyHashMap {

    /*
    idea: use an 2d array to store the key, value pair
    */
    ArrayList<ArrayList<Integer>> pairs;
    public MyHashMap() {
        pairs = new ArrayList();
    }
    
    public void put(int key, int value) {
        Boolean added = false;
        for (ArrayList<Integer> keys: pairs) {
            if (keys.get(0) == key) {
                keys.set(1, value);
                added = true;
                break;
            }
        }
        if (!added) {
            ArrayList<Integer> newPair = new ArrayList<>();
            newPair.add(key);
            newPair.add(value);
            pairs.add(newPair);
        }
    }
    
    public int get(int key) {
        for (ArrayList<Integer> keys: pairs) {
            if (keys.get(0) == key) {
                return keys.get(1);
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        if (pairs.isEmpty()) return;
        int index =0;
        for (ArrayList<Integer> keys: pairs) {
            if (keys.get(0) == key) {
                break;
            }
            index++;
        }
        if (index == pairs.size()) return;
        pairs.remove(index);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */