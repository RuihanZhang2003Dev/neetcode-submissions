class UnionFind {
    private int[] parent;
    private int[] size;
    
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i =0; i< n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    // Union-find
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int parentx = find(x);
        int parenty = find(y);

        if (size[parentx] > size[parenty]) {
            size[parentx] += size[parenty];
            parent[parenty] = parentx;
        }

        else {
            size[parenty] += size[parentx];
            parent[parentx] = parenty;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        /*
        idea: instead of account name guiding to emails, we can use emails to guide to account indexes
        of account, use a hashmap. if a email already exists in the map when we iterate through other
        accounts, then we merge account.
        */
        int len = accounts.size();
        UnionFind uf = new UnionFind(len);
        Map<String, Integer> emailToAcc = new HashMap<>();  // email -> index acc
        for (int i = 0; i < len; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j< account.size(); j++) {
                String email = account.get(j);
                // if the email was seen before, union the two account set
                if (emailToAcc.containsKey(email)) {
                    uf.union(i, emailToAcc.get(email));
                }
                else {
                    emailToAcc.put(email, i);
                }
            }
        }

        // group emails by leader account
        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToAcc.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int leader = uf.find(accId);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

        // build result
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);
            res.add(merged);
        }
        return res;
    }


    
}