class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        idea: use a stack to store the day number where the temperature situates, when the current 
        temperature occurs and is warmer than the temp at that day, then pop it and calculate the day 
        difference between current day and that day
        */

        Stack<Integer> days = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i< temperatures.length; i++) {
            if (days.isEmpty()) days.push(i);
            else {
                int cur = temperatures[i];
                while (!days.isEmpty() && cur > temperatures[days.peek()]) {
                    int day = days.pop();
                    result[day] = i -day;
                }
                days.push(i);
            }
        }
        while (!days.isEmpty()) {
            int day = days.pop();
            result[day] = 0;
        }
        return result;
    }
}
