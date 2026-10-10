class TimeMap {
    HashMap<String, ArrayList<Integer>> map;
    ArrayList<String> values;
    ArrayList<Integer> timestamps;
    public TimeMap() {
        /*
        idea: so 1 hashmaps that contains a arraylist of indexes, and those will    
        indexes are used to indicate the location of the timestamp and values
        */
        map = new HashMap<>();
        values = new ArrayList<>();
        timestamps = new ArrayList<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Integer>());
        }
        map.get(key).add(values.size());
        values.add(value);
        timestamps.add(timestamp);
    }
    
    public String get(String key, int timestamp) {

        if (!map.containsKey(key)){
            return "";
        }
        
        // perform binary search to find the latest timestamp
        else {
            ArrayList<Integer> indexes = map.get(key);
            int left = 0;
            int right = indexes.size() -1;
            String value = "";

            while (left <= right) {
                int mid = (left + right) /2;
                if (timestamps.get(indexes.get(mid)) > timestamp) {
                    right = mid-1;
                }
                else {
                    value = values.get(indexes.get(mid));
                    left = mid +1;
                }
            }
            return value;
        }
    }
}
