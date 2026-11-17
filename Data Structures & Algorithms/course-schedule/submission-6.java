class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        idea: use kahn's theorem, build adjacency list and keep count of in degrees, then we will
        start by removing nodes with indegrees of 0 and update indegree, then we push those nodes
        who now have indegree of 0
        */
        
        int[] indegrees = new int[numCourses];
        List<Integer>[] adj_list = new ArrayList[numCourses];
        for (int i =0 ; i< adj_list.length; i++) {
            adj_list[i] = new ArrayList<>();
        }

        // build adjacency lists and indegrees
        for (int[] prereq: prerequisites) {
            int from = prereq[0];
            int to = prereq[1];
            indegrees[to]++;
            adj_list[from].add(to);
        }

        Queue<Integer> courses = new LinkedList<>();
        int done =0;
        // add courses of indegree 0 to courses
        for (int i = 0; i< indegrees.length; i++) {
            if (indegrees[i] == 0) courses.offer(i);
        }

        while (!courses.isEmpty()) {
            int cur = courses.poll();
            done++;
            for (int prereq: adj_list[cur]) {
                indegrees[prereq]--;
                if (indegrees[prereq] == 0) courses.offer(prereq);
            }
        }
        // at the end, check if all courses has indegree of 0
        return done == numCourses;

    }
}








