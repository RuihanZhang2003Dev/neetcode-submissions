class Solution{
    public int[][] kClosest(int[][] points, int k) {
        /*
        idea: use minheap with priority queue, use the distance of the coordinate as element
        in the queue, use a hashmap to store the disctance and the coordinates that corresponds
        to it
        */

        PriorityQueue<Double> pq = new PriorityQueue<>();
        HashMap<Double, ArrayList<int[]>> map = new HashMap<>();
        int[][] result = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            pq.add(distance);
            if (!map.containsKey(distance)) map.put(distance, new ArrayList<>());
            map.get(distance).add(points[i]);
        }

        // now the heap is built and the map is created, extract k many points
        for (int j = 0; j < k; j++) {
            Double removed= pq.poll();
            result[j] = map.get(removed).remove(0);
        }

        return result;

    }
}
