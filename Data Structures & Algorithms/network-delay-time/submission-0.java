class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        idea: get use dijkstras, where the starting point will be k, so in order to make this happen
        we use a priority queue, where priority is decided with the current distance from the starting
        node to the current node. shorter one is in the front

        to initialize dijkstra, build adjacency list and a hashmap with <from, to> as key and time as
        value. 
        when iterating, we use 2 arrays to store the list of distances and the list of previous node.
        then to iterate, we use an priority queue using the time 
        */
        
        Node[] nodes = new Node[n +1];
        int[] shortestDists = new int[n+1];
        int[] prevNodes = new int[n+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]);

        // initialize nodes
        for (int i = 1; i < nodes.length; i++) {
            if (i != k) {
                shortestDists[i] = Integer.MAX_VALUE;
            }
            nodes[i] = new Node(i);
        }

        // construct graph
        for (int[] edge: times) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];
            

            nodes[from].neighbors.put(nodes[to], time);
        }

        // start dijkstras with node k 
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            // pop current node, get its adjacency lists, run through it and update the smallest 
            // distance
            int[] curPair = queue.poll();
            int curNode = curPair[0];
            int curDist = shortestDists[curNode];
            
            for (Node node: nodes[curNode].neighbors.keySet()){
                int distance = curDist + nodes[curNode].neighbors.get(node);
                // if the distance from this path is shorter than current one, then update it
                if (shortestDists[node.num] > distance) {
                    shortestDists[node.num] = distance;
                    prevNodes[node.num] = curNode;
                    queue.offer(new int[]{node.num, distance}); // only enqueue when the time is updated
                }
                
            }
        }
        int minTime = 0;
        for (int i = 1; i< prevNodes.length; i++) {
            if (shortestDists[i] == Integer.MAX_VALUE) return -1;  // there are unreachable nodes
            minTime = Math.max(minTime, shortestDists[i]);
        }
        return minTime;

    }

    public class Node{
        int num;
        HashMap<Node, Integer> neighbors;    // stores node and time

        public Node(int val) {
            num = val;
            neighbors = new HashMap<>();
        }
    }


}
