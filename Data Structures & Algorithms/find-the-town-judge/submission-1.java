class Solution {
    public int findJudge(int n, int[][] trust) {
        // idea: find the person who doesnt trust any one but everyone trusts him, so just make a hash
        // table on indegree of everyone (being trusted) and outdegree of everyone (trusts)
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for (int i = 1; i<= n ; i++) {
            in.put(i, 0);
            out.put(i, 0);
        }

        for (int[] edge: trust) {
            in.put(edge[1], in.get(edge[1])+1);
            out.put(edge[0], out.get(edge[0])+1);
        }
        int res = -1;
        for (int i = 1; i <= n; i++) {
            int trusted = in.get(i);
            int trusts = out.get(i);
            if (trusted == n -1 && trusts == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}