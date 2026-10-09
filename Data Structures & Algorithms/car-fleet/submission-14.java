class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
        idea: use a stack to keep track of the car fleets. Sort the array first base
        on position and speed. then iterate through them right to left, if the car
        takes less or equal time to reach the desitination, delete the car behind 
        from the stack, so that they kind of become the same car fleet
        */

        // sort the array
        HashMap<Integer, Integer> cars = new HashMap<>();
        for (int i = 0 ; i< position.length; i++) {
            cars.put(position[i], speed[i]);
        }
        Arrays.sort(position);

        float prevTime= 0;
        // after sorting, find fleets
        Stack<Integer> fleets = new Stack<>();
        for (int j = position.length-1; j > -1; j--) {
            float curTime = (float) (target- position[j]) / cars.get(position[j]);
            if (fleets.isEmpty()) {
                fleets.push(position[j]);
                prevTime = curTime;
                continue;
            }
            // if the car behind takes more time, push so that it is a independant
            // fleet
            if (curTime > prevTime){
                fleets.push(position[j]);
                prevTime = curTime;
            }
            
        }
        return fleets.size();
    }   
}
