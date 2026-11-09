class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
        idea: build a hashmap to correspond position and speed, then sort by position, and iterate
        from the position closest (n -1) to the furthest(0), calculate how long would it take, and 
        store it to the stack if empty, if the stack is not empty, then we will check if current one
        will be arriving to target faster than its previous car, if it does, that means they will
        meet somewhere in the road the the faster car will have the same speed as the car in front of
        it, that means they will be 1 fleet upon arrival, so we do not push its time to the stack,
        if the car takes longer to arrive to target, then push it to the stack since it means the 
        current car will not join the car in front of it to form a fleet.
        */
        HashMap<Integer, Integer> cars = new HashMap<>();
        for (int i = 0; i< position.length; i++) {
            cars.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        Stack<Double> fleets = new Stack<>();
        for (int i = position.length -1; i>= 0; i--) {
            int curPos = position[i];
            double time = (double) (target- curPos)/cars.get(curPos);
            if (fleets.isEmpty()) {
                fleets.push(time);
                continue;
            }
            else {
                // check the time taken to get to target by the car in front
                double prev = fleets.peek(); 
                // if previous car is faster to arrive than the current one, the current car will
                // not chase up, so the car itself forms a fleet. otherwise do nothing to stack
                // since the current car will chanse up and form a fleet with the car in front.
                // hence it will not have a separate time of arrival
                if (prev < time) fleets.push(time);
            }
        }
        return fleets.size();
    }
}
