class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        idea: sort interval from starting time, then run 3 while loop: one to add all interval that ends
        before the new interval, then one to merge all interval that overlaps with newInterval, then add
        all intervals after the new interval
        */
        if (intervals.length == 0) return new int[][]{newInterval};
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> inters = new ArrayList<>();

        int n = intervals.length;
        int ind = 0;
        int new_start = newInterval[0];
        int new_end = newInterval[1];

        while (ind < n && intervals[ind][1] < new_start) {
            inters.add(intervals[ind]);
            ind++;
        }
        
        while (ind < n && intervals[ind][0]<= new_end) {
            new_start = Math.min(intervals[ind][0], new_start);
            new_end = Math.max(intervals[ind][1], new_end);
            ind++;
        }
        inters.add(new int[]{new_start, new_end});
        
        while (ind < n) {
            inters.add(intervals[ind]);
            ind++;
        }
        int[][] res = new int[inters.size()][2];
        for (int i =0; i< res.length; i++) {
            res[i] = inters.get(i);
        }
        return res;
    }
}
