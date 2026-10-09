class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        idea: use binary search to find the minimum number of bananas that needs to be eaten to go through
        the pile. start by 0 being min and max being the number of bananas from max pile
        */
        int maxSpeed = -1;
        int minSpeed = 1;

        // find max pile
        for (int i = 0; i< piles.length; i++) {
            if (piles[i] > maxSpeed) maxSpeed = piles[i];
        }
        System.out.println(maxSpeed);

        int finalSpeed = 0;
        // binary search here
        while (minSpeed <= maxSpeed) {
            // + 1 to assure getting the right midspeed, since it truncate the .5
            int midSpeed = (minSpeed + maxSpeed +1) /2;
            // check if midspeed is the minSpeed
            int hourTaken = 0;
            for (int i = 0; i< piles.length; i++) {
                if ((piles[i] % midSpeed) != 0) hourTaken++;
                hourTaken += piles[i] / midSpeed;
            }
            // if it takes longer than hour limitation, it is too slow, take the higher speed
            if (hourTaken > h) {
                minSpeed = midSpeed+1;
            }
            // if it takes less, it is a working speed, check left part to see if there is room for better
            // answer
            else {
                finalSpeed = midSpeed;
                maxSpeed = midSpeed -1;
            }
        }
        return finalSpeed;

    }
}
