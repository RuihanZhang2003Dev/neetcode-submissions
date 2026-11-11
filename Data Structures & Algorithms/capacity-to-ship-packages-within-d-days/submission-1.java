class Solution {
    public int shipWithinDays(int[] weights, int days) {
        /*
        idea: koko on steroid, find the min weight from which we can deliver all the packages in days
        */
        int maxWeight = 0;
        int minWeight = 1;

        for (int w: weights) {
            maxWeight += w; // max weight is the total weight, which allows us to take all packages
            // in a day
            minWeight = Math.max(minWeight, w);
            // min weight is the minimum weight each ship has to be able to carry, which is the size
            // of the largest cargo, since we need to be able to carry it in a single day
        }

        int finalWeight = 0;
        while (minWeight <= maxWeight) {
            int midWeight = minWeight + (maxWeight - minWeight)/2;

            int countDay = 1;
            int weightLeft = midWeight; // since all cargo has to go in order, and we can take many
            // cargo at a day as long as the ship allows, only increase daycount when there is no
            // space
            for (int w: weights) {
                if (weightLeft < w) {
                    countDay++;
                    weightLeft = midWeight;
                }
                weightLeft -= w;
            }
            
            // if it takes too long, speed up, take right
            if (countDay> days) minWeight = midWeight +1;
            // if it takes within the require days, update result and look if we can take smaller 
            // weight will achieving the goal within days
            else {
                finalWeight = midWeight;
                maxWeight = midWeight -1;
            }
        }
        return finalWeight;
    }
}