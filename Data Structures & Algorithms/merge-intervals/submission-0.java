class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        idea: assuming that the intervals are not sorted, sort the intervals with its starting time,
        then create a new list, if the current interval is non overlapping with its previous one, 
        then add previous one to the mix, otherwise merge it
        */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = intervals[0];
        List<int[]> result = new ArrayList<>(); 
        for (int i= 1; i< intervals.length; i++) {
            // if the current one is not overlapping with its prev (prev ended before cur starts), 
            // add prev to the result and update prev
            int[] cur = intervals[i];
            if (prev[1] < cur[0]) {
                result.add(prev);
                prev = cur;
            }
            else {
                prev[0] = Math.min(prev[0], cur[0]);
                prev[1] = Math.max(prev[1], cur[1]);
            }
        }
        result.add(prev);   // one last addition since there will always be a prev in the loop
        return result.toArray(new int[result.size()][]);
    }
}
