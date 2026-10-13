class Solution {
    public int findDuplicate(int[] nums) {
        /*
        idea: use slow fast to get where they intersect in cycle, then start another slow from the 
        beginning and check where they intersect, they will intersect at the start of the cycle 
        */

        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) break;
        }
        return slow;
    }
}
