class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
        idea: use a hashmap to correspond each car's position and speed, then sort the positions. 
        after that, iterate through positions from the nearest to target to furthest. calculate the 
        time taken from that position to target. if there is a car in front and the current car is 
        faster than the car in front (takes less time to reach target), then the curretn car will 
        catch up and slow down to form a fleet with the car in front of it. otherwise if the car 
        takes longer to arrive to the end than the car in front, then the current car forms a new 
        fleet itself
        */
        HashMap<Integer, Integer> cars = new HashMap<>();
        for (int i = 0; i< position.length; i++) {
            cars.put(position[i], speed[i]);
        }
        Stack<Double> fleets = new Stack<>();   
        Arrays.sort(position);

        for (int i = position.length -1; i>= 0; i--) {
            int curPos = position[i];
            double time = (double) (target - curPos)/cars.get(curPos);
            if (fleets.isEmpty()) {
                fleets.push(time);
                continue;
            }
            else {
                Double prev = fleets.peek();
                if (prev < time) fleets.push(time);
            }
        }
        return fleets.size();
    }
}
