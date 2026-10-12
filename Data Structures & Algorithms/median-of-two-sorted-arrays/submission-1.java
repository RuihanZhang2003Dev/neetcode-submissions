class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // from here on, nums1 is the smaller (or equal) one

        int m = nums1.length;
        int n = nums2.length;
        int leftLen = (m + n) / 2;   // size of the left half

        int lo = 0, hi = m;          // how many of nums1 go left: anywhere from 0 to m
        while (lo <= hi) {
            int i = (lo + hi) / 2;   // count taken from nums1
            int j = leftLen - i;     // count taken from nums2

            // the 4 boundary values; off the edge = infinitely small/big
            int left1  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int left2  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (left1 <= right2 && right1 >= left2) {
                // TODO 2: return the median
                //   even total: ?
                if ((m+n) %2 == 0) {
                    return (double) (Math.max(left1, left2) + Math.min(right1,right2)) /2;
                }
                //   odd total:  ? (the left half is the SMALLER half here)
                else {
                    return (double) Math.min(right1, right2);
                }
            } else if (left1 > right2) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }
        return -1; // never reached
    }
}