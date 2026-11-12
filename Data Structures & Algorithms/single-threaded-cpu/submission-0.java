class Solution {
    public int[] getOrder(int[][] tasks) {
        /*
        idea: have a min heap on equeue time so CPU can perform task as soon as possible, have another 
        minheap for process time when the tasks become available. since when the task becomes 
        available at given time, the cpu prioritize the process time, this way the cpu will start by
        executing the task with smallest enqueue time and after the process time, some other tasks 
        with different enqueue time become available. at this point, we will be able to select from 
        all available tasks the task that takes the shortest time.
        */

        PriorityQueue<int[]> minEnque = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minTask = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int time =0;
        ArrayList<Integer> order = new ArrayList<>();
        // build minEnqueue
        for (int i = 0; i< tasks.length; i++) {
            int[] task = tasks[i];
            minEnque.offer(new int[]{task[0], task[1], i});
        }

        while (!minEnque.isEmpty() || !minTask.isEmpty()) {
            // enqueue the available task
            while (!minEnque.isEmpty() && minEnque.peek()[0] < time) minTask.offer(minEnque.poll());
            if (!minTask.isEmpty()) {
                // take the task that takes the least time
                int[] task = minTask.poll();
                time += task[1];
                order.add(task[2]);
            } 
            else time++;
        }

        int[] res = new int[order.size()];
        for (int i = 0; i< res.length; i++) res[i] = order.get(i);
        return res;
    }
}