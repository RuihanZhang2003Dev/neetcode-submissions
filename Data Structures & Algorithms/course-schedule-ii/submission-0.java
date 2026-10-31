class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        idea: same idea as course schedule 1, use kahn's theorem so that we can pop those who
        has 0 indegree, then at each iteration, pop the front fo the queue, update the indegree
        and those have now have indegree of 0 will now be pushed back to the queue. Since we are
        building an ordering, we will use an array to store the order of the course done from 
        queue by running kahn's
        */

        // we do it little differently: instead of 0 pointing to 1 we will do 1 pointing to 0
        int[] indegree = new int[numCourses];
        List<List<Integer>> courses = new ArrayList<>();

        // build the nodes list
        for (int i = 0; i< numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        for (int[] prereq: prerequisites) {
            indegree[prereq[0]]++;
            courses.get(prereq[1]).add(prereq[0]);
        }

        // build the queue now
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        // now BFS
        int[] order = new int[numCourses];
        int finished = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            order[finished] = course;
            for (int nextCourse :courses.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    q.offer(nextCourse);
                }
            }
            finished++;
        }
        if (finished == numCourses) return order;
        return new int[]{};
    }
}
