class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        idea: lets do kahn's theorem, so we need to keep track of the indegree for all courses
        use a queue to enqueue the ones that have indegree of 0, pop them, update the indegree
        and requeue those who have indegree of 0 (we only have to check the indegree of those
        we just updated since they are the only ones who can have indegree of 0 at this point)
        */

        int[] indegree = new int[numCourses];
        List<List<Integer>> courses = new ArrayList<>();

        // build the course list nodes
        for (int i = 0; i < numCourses; i++) courses.add(new ArrayList<>());

        for (int[] prereq: prerequisites) {
            indegree[prereq[1]]++;
            courses.get(prereq[0]).add(prereq[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        // enqueue those who has 0 indegrees first to build initial queue
        for (int i = 0; i< indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // count the finished courses
        int finished = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            for (int prereq: courses.get(course)) {
                indegree[prereq]--; // update the indegree of the prereq
                if (indegree[prereq] == 0) q.add(prereq);
            }
            finished++;
        }
        return finished == numCourses;
    }
}












