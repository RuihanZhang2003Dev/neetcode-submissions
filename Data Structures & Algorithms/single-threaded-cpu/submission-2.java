class Solution {
    public int[] getOrder(int[][] tasks) {
        /*
        idea: have a min heap on equeue time so CPU can perform task as soon as possible, have another 
        minheap for process time when the tasks become available. since when the task becomes 
        available at given time, the cpu prioritize the process time, this way the cpu will start by
        executing the task with smallest enqueue time and during the process time, some other tasks 
        with different enqueue time and process time become available. at this point, we will be able 
        to select from available tasks the task that takes the shortest time from the minheap of 
        minimum process time.
        or we sort the array of tasks by enqueue time
        */

        int len = tasks.length;
        for (int i =0; i< len; i++) {
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        PriorityQueue<int[]> minTask = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int time =0;
        int[] res = new int[tasks.length];
        // sort array
        Arrays.sort(tasks, Comparator.comparingInt(t-> t[0]));
        int i = 0; int ind = 0;

        while (i< len || !minTask.isEmpty()) {
            // enqueue the available task
            while (i < len && tasks[i][0] <= time) {
                minTask.offer(tasks[i]);
                i++;
            }
            if (!minTask.isEmpty()) {
                // take the task that takes the least time
                int[] task = minTask.poll();
                time += task[1];
                res[ind++] = task[2];
            } 
            else time++;
        }

        
        return res;
    }
}