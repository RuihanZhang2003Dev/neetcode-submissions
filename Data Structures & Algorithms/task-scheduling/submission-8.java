class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        idea: since the time taken to perform tasks is limited to the most reccurring task, we will 
        make a max heap on the reoccurrance of task. Then we will take the most reoccurring task. 
        perform it. then store it in a queue with its occurrance reduced and the time it can get out.
        at the time it can get out, we put it back to the task queue
        */

        // construct frequency list
        int[] freq = new int[26];
        for (char c: tasks) {
            freq[c - 'A']++;
        }

        // get the max heap
        PriorityQueue<Integer> ts= new PriorityQueue<>(Collections.reverseOrder());
        for (int f: freq) {
            if (f > 0) ts.offer(f);
        }

        // we will use a queue to store the pair of task and its cooldown
        Queue<int[]> cooldown = new LinkedList<>();
        int timer = 0;
        while (!ts.isEmpty() || !cooldown.isEmpty()) {
            // if there is a task that we can perform rn, perform it, reduce freq and put it to 
            // cooldown
            if (!ts.isEmpty()) {
                int t = ts.poll();
                if (t > 1) cooldown.offer(new int[]{t -1, timer + n});
            }
            // after that, if there is task where cooldown is done, push the freq back to max heap
            while (!cooldown.isEmpty() && cooldown.peek()[1] == timer) ts.offer(cooldown.poll()[0]);
            timer++;
        }
        return timer;
    }

    
}
