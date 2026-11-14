class Solution {
    public int findJudge(int n, int[][] trust) {
        // idea: find the person who doesnt trust any one but everyone trusts him, so just make an array
        // on indegree of everyone (being trusted) and outdegree of everyone (trusts)
        int[] people = new int[n +1];

        for (int[] edge: trust) {
            people[edge[0]]--;
            people[edge[1]]++;
        }
        int res = -1;
        for (int i = 1; i <= n; i++) {
            int score = people[i];
            if (score == n -1) {
                res = i;
                break;
            }
        }
        return res;
    }
}