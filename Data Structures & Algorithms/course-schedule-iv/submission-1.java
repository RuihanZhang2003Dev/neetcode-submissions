class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        /*
        idea: instead of using kahn's, we can just use dfs on each course, and find all reachable
        courses by the current courses and put it into a hashmap with num course as key and its 
        reachable courses (a hashset) as value
        */
        // build adjacency list
        List<Integer>[] adj = new ArrayList[numCourses];
        Map<Integer, HashSet<Integer>> reachable = new HashMap<>();
        
        for (int i =0; i< adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prereq: prerequisites) {
            int from = prereq[0];
            int to = prereq[1];

            adj[from].add(to);
        }

        for (int i = 0; i< numCourses; i++) {
            dfs(i, adj, reachable);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query: queries) {
            int from = query[0];
            int to = query[1];
            res.add(reachable.get(from).contains(to));
        }
        return res;
    }
    
    private HashSet<Integer> dfs(int start, List<Integer>[] adj, Map<Integer, HashSet<Integer>> map) {
        if (!map.containsKey(start)) {
            map.put(start, new HashSet<>());
            for (int prereq: adj[start]) {
                map.get(start).addAll(dfs(prereq, adj, map));
            }
            map.get(start).add(start);
        }
        return map.get(start);
    }


}