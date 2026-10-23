class Twitter {
    int count;
    HashMap<Integer, HashSet<Integer>> followMap;   // user to followee ids
    HashMap<Integer, List<int[]>> tweetMap;   // user to tweets ids

    public Twitter() {
        count = 0;
        followMap = new HashMap<>();    
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) tweetMap.put(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{this.count, tweetId});
        this.count += 1;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        /*
        idea: build a max heap of tweetids by getting the tweets from followeeId of the userId
        then extract the firts 10
        */
        follow(userId, userId);
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        // go through all the followee of the user
        for (int followee: followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                // extract the most recent tweet from each user
                int index = tweetMap.get(followee).size() -1; 
                int[] tweet = tweetMap.get(followee).get(index);
                maxHeap.add(new int[]{tweet[0], tweet[1], followee, index -1}); 
                // index -1 to signify the next most recent post we are going to be looking at
            }
        }
        while (!maxHeap.isEmpty() && result.size()< 10) {
            int[] tweet = maxHeap.poll();
            result.add(tweet[1]);
            if (tweet[3] >= 0) {
                int[] newTweet = tweetMap.get(tweet[2]).get(tweet[3]);  // get the next most    
                // recent tweet from the same user if there is any
                maxHeap.add(new int[] {newTweet[0], newTweet[1], tweet[2], tweet[3] -1});
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
            followMap.get(followerId).add(followerId);  // detail: when extracting, the user itself is also considered as one of the followee by the user.
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId).contains(followeeId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
