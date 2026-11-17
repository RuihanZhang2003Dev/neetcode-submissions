class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        /*
        idea: we will be storing all courses that are reachable with this course as prereq. first we 
        will build the adjacency list, then we will use dfs to find all indirect prereqs, and store them
        all in a hashmap, then we go through the queries and check if the course has the indirect prereq
        */
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        List<Integer>[] adj = new ArrayList[numCourses];

        // make the adjacency list
        for (int i =0; i< numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prereq: prerequisites) {
            int from = prereq[0];
            int to = prereq[1];

            adj[from].add(to);
        }

        // run dfs on all of the courses and construct the map, the map of prereq and all courses linked
        // to it
        for (int i = 0; i< numCourses; i++) {
            dfs(i, map, adj);
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] query: queries) {
            res.add(map.get(query[0]).contains(query[1]));
        }
        return res;

    }

    //private helper
    private HashSet<Integer> dfs(int course, Map<Integer, HashSet<Integer>> map, List<Integer>[] adj) {
        // if the map does not have course yet, then add course to the map and iterate through its
        // neighbors for direct and indirect prereqs
        if (!map.containsKey(course)) {
            map.put(course, new HashSet<>());
            for (int nei: adj[course]) {
                map.get(course).addAll(dfs(nei, map, adj));
            }
            map.get(course).add(course);    //when there is no more neighbors, add itself for future
        }
        return map.get(course);
    }
}