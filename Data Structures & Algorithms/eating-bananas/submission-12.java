class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        idea: to get a eating speed that takes under h and that is closest to h, use binary search on the speed
        if a speed works, meaning it takes less than h, update speed and look for slower speed that takes also
        under h to finish piles, inital max speed would be the speed where you eat the largest pile
        */

        long maxSpeed= -1;
        long minSpeed = 1;

        for (long n: piles) maxSpeed = Math.max(maxSpeed, n);

        long finalSpeed = 0;
        while (minSpeed <= maxSpeed) {
            long midSpeed = minSpeed + (maxSpeed - minSpeed)/2;

            long curTime = 0;
            for (long pile: piles) {
                if (pile % midSpeed > 0) curTime++;
                curTime += pile/midSpeed;
            }

            // if we took too long to eat all piles, too slow, take right
            if (curTime > h) minSpeed = midSpeed+1;
            // if we took time shorter than h, look if there is better answer by taking left
            else if (curTime <= h) {
                finalSpeed = midSpeed;
                maxSpeed = midSpeed -1;
            }
        }
        return (int) finalSpeed;
    }
}
