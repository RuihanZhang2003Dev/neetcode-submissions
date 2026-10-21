class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        idea: does not matter what the task is specifically, all we need is their occurrences. 
        we should start with the most occurring task, for that we will need a max heap. and when
        we went through that task, we should put it into a hashmap that has <time when the task
        is cooled down, task occurrences>. so that when the time comes, we can liberate it and 
        put it back to the max heap, since it is available to be completed again
        */

        // 1. go through the tasks and find iterations
        HashMap<Character, Integer> occurrence = new HashMap<>();
        for (int i = 0; i< tasks.length; i++) {
            if (!occurrence.containsKey(tasks[i])) occurrence.put(tasks[i], 0);
            occurrence.put(tasks[i], occurrence.get(tasks[i]) +1);
        }

        // build the heap
        PriorityQueue<Integer> occur = new PriorityQueue(Collections.reverseOrder());
        for (int value: occurrence.values()) {
            occur.add(value);
        } 

        int time = 0;   // time
        HashMap<Integer, Integer> cooldown = new HashMap<>();

        while (!occur.isEmpty() || !cooldown.isEmpty()) {
            // if there are task that at this time should be back to the queue, get it back
            // and remove it from cooldown
            if (cooldown.containsKey(time)) {
                occur.add(cooldown.get(time));
                cooldown.remove(time);
            }

            if (occur.isEmpty()) {
                // if it is empty, then increase timer and skip this round
                time++;
                continue;
            }

            int task = occur.poll();
            task = task -1; // decrease occurrence of that task,
            if (task != 0) {
                cooldown.put(time +n +1, task);  // set the cooldown here if there are more task
                // remaining, +1 is to include the time we took to perform this task.
            }
            
            
            time++;
        }
        return time;
    }
}
