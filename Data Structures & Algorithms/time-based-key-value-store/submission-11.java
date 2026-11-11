class TimeMap {
    /*
    idea: use a Map with key as key and a pair of <timestamp, value> as value
    */
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    // use binary search to find the right pair
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<Integer, String>> valueList = map.get(key);
        int start = 0;
        int end = valueList.size() -1;

        Pair<Integer, String> finalPair = null;
        while (start <= end) {
            int mid = start + (end -start)/2;
            
            // if we searched too far, go left, get closer
            if (valueList.get(mid).getKey() > timestamp) end = mid -1;
            else {
                finalPair = valueList.get(mid);
                start = mid+1;
            }
        }
        if (finalPair == null) return "";
        return finalPair.getValue();
    }


    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key =key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
    }
}
