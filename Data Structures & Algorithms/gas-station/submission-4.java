class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        idea: if we have more gas at this point than cost, then this point is a valid start,
        if from this station, we cannot go to the end (meaning at some point the cost is 
        > gas after that point), find the next valid point
        */
        int total_gas = 0;
        int total_cost = 0;
        int valid_station = -1;

        int gas_left = 0;
        for (int i = 0; i< gas.length; i++) {
            total_gas += gas[i];
            total_cost += cost[i];

            gas_left += gas[i] - cost[i];
            if (gas_left < 0) {
                gas_left = 0;
                valid_station = -1;
            }
            else if (valid_station == -1) valid_station = i;
        }
        if (total_gas < total_cost) return -1;

        return valid_station;
    }

            
    
}
