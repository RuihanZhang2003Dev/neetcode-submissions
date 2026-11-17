class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i =0; i< n; i++) {
            size[i] =1;
            parent[i] = i;
        }
    }

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
            parent[parenty] = parentx;
            size[parentx] += size[parenty]; 
        }
        else {
            parent[parentx] = parenty;
            size[parenty] += size[parentx]; 
        }
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        /*
        idea: use a hashmap to store which name the email belongs to, if when we iterate 
        through the email, the email is already in hashmap, that means we have to merge the
        current account and the account who was also holding the same account
        */
        int len = accounts.size();
        UnionFind uf = new UnionFind(len);
        Map<String, Integer> emailToAcc = new HashMap<>();
        for (int i =0 ; i< len; i++) {
            List<String> account = accounts.get(i);
            for (int j =1; j< account.size(); j++) {
                String email = account.get(j);
                if (emailToAcc.containsKey(email)) {
                    // if the hashmap already contains an account that has that email, merge
                    // both account
                    uf.union(i, emailToAcc.get(email));
                }
                else {
                    emailToAcc.put(email, i);
                }
            }
        }

        // grouping all emails in groups
        Map<Integer, List<String>> groups = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToAcc.entrySet()) {
            String email = entry.getKey();
            int accInd = entry.getValue();
            int leader = uf.find(accInd);
            groups.putIfAbsent(leader, new ArrayList<>());
            groups.get(leader).add(email);
        }

        // make the result out of the groups
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: groups.entrySet()) {
            List<String> emails = entry.getValue();
            int leader = entry.getKey();
            String name = accounts.get(leader).get(0);
            List<String> toAdd = new ArrayList<>();
            toAdd.add(name);
            toAdd.addAll(emails);
            res.add(toAdd);
        }
        return res;

    }
}



