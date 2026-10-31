class Solution {
    Set<Integer> visiting = new HashSet<>();
    Map<Integer, List<Integer>> courseMap = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        idea: build a directed graph with adjacency list, so each course has a dependancy list
        use a hashmap to store that, with the current course as key and its prereq as dependancy
        run dfs until a node does not have any dependancy (which means the current course path
        is valid), then comes back, remove the course ran in prereq, if there is more prereq, 
        run dfs on that.
        */

        // build the map, really simple as the courses are labeled from 0 to numcourses -1
        for (int i = 0; i< numCourses; i++) courseMap.put(i, new ArrayList<>());

        for (int[] prereq: prerequisites) courseMap.get(prereq[0]).add(prereq[1]);

        for (int i = 0; i< numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    // helper for the main function that checks if this courseMap can do that numcourses, detect
    // loop
    private boolean dfs(int course) {
        // check loop
        if (visiting.contains(course)) return false;
        if (courseMap.get(course).isEmpty()) return true;

        // update to set for this iteration
        visiting.add(course);

        // checks all the its prereq to ensure that it can be reached in a path
        for (int prereq: courseMap.get(course)) {
            if (!dfs(prereq)) return false;
        }

        // remove from the set
        visiting.remove(course);
        
        // remove all prereq as we have checked all and every prereq can be done
        courseMap.put(course, new ArrayList<>());
        return true;
    }
}












