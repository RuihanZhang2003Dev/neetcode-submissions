class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        /*
        idea: run dfs on each course, and use a hashset for each course in a hashmap, so that if the
        course already exists in the hashmap, we can just use that
        */

        // build adjacency list first
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i< adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prereq: prerequisites) {
            int from = prereq[0];
            int to = prereq[1];
            adj[from].add(to);
        }

        for (int i = 0; i< numCourses; i++) {
            dfs(i, prereqMap, adj);
        }
        List<Boolean> res= new ArrayList<>();
        // to see if the first course is a prereq of the other course
        for (int[] query: queries) res.add(prereqMap.get(query[0]).contains(query[1]));
        return res;
    }

    private Set<Integer> dfs(int course, Map<Integer, Set<Integer>> prereqMap, List<Integer>[] adj) {
        // in dfs, if the map does not contain course, we will iterate through its neighbors to get
        // all courses its neighbors can reach, until the neighbor can only reach itself, in that 
        // case we will return its reachable nodes
        if (!prereqMap.containsKey(course)) {
            prereqMap.put(course, new HashSet<>());
            for (int prereq: adj[course]) {
                prereqMap.get(course).addAll(dfs(prereq, prereqMap, adj));
            }
            prereqMap.get(course).add(course);
        }
        return prereqMap.get(course);
    }

}