class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        idea: same question as course schedule 1, but now we just need to put the courses we take
        in order
        */
        int[] indegrees = new int[numCourses];
        List<Integer>[] adj_list = new ArrayList[numCourses];
        for (int i = 0; i< adj_list.length; i++) {
            adj_list[i] = new ArrayList<>();
        }

        for (int[] prereq: prerequisites) {
            // in order to take 0 we need 1
            int from = prereq[1];
            int to = prereq[0];
            indegrees[to]++;
            adj_list[from].add(to);
        }

        Queue<Integer> courses= new LinkedList<>();
        // find courses of indegree 0
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) courses.offer(i);
        }

        List<Integer> order = new ArrayList<>();
        while (!courses.isEmpty()) {
            int cur = courses.poll();
            order.add(cur);
            for (int nei: adj_list[cur]) {
                indegrees[nei]--;
                if (indegrees[nei] == 0) courses.offer(nei);
            }
        }
        if (order.size() ==numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i< res.length; i++) {
                res[i] = order.get(i);
            }
            return res;
        }
        return new int[]{};
    }
}
