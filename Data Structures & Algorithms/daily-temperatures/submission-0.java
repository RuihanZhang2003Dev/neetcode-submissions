class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        idea: it would push the unresolved temperature into the stack
        (so the temperature where the warmer day was not found will be put there
        until we find a warmer day) once we reached the warmer day, pop the 
        unresolved days until we cannot no more
        */
        int[] result = new int[temperatures.length];
        Stack<Integer> temp = new Stack<>();
        int counter = 1;
        temp.push(temperatures[0]);

        for (int i = 1; i< temperatures.length; i++){

            if (temperatures[i] > temp.peek()){
                while ((!temp.isEmpty() && temperatures[i] > temp.peek())){
                    // if there is a result == there is a number already popped, 
                    // skip one iteration
                    if (result[i- counter] != 0) {
                        counter++;
                        continue;
                    }
                    temp.pop();
                    result[i- counter] = counter;
                    counter += 1;
                }
            }
            counter = 1;
            temp.push(temperatures[i]);

        }
        return result;
    }
}
