class Twitter {

    Map<Integer, Set<Integer>> following;
    Map<Integer, List<int[]>> tweets;
    int post_count;
    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        post_count= 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        // userId -> tweetId
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, post_count});
        post_count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // maxHeap for followees' most recent tweets
        PriorityQueue<int[]> ts = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        List<Integer> res = new ArrayList<>();
        
        follow(userId, userId);
        // put the most recent followee_tweets of users in the priority queue, pop the most recent one
        // if they got more, put the next one back in
        for (int followee: following.get(userId)) {
            List<int[]> followee_tweets= tweets.get(followee);
            if (followee_tweets == null) continue;
            else {
                int[] latest = followee_tweets.get(followee_tweets.size() -1);
                // info about followee_tweets, followee id, and next most recent posted 
                // followee_tweets index
                ts.offer(new int[]{latest[0], latest[1], followee, followee_tweets.size() -2});
            }
        }
        
        while (res.size() < 10 && !ts.isEmpty()) {
            int[] mostRecent = ts.poll();
            if (mostRecent[3] >= 0) {
                int[] next = tweets.get(mostRecent[2]).get(mostRecent[3]);
                ts.offer(new int[]{next[0], next[1], mostRecent[2], mostRecent[3] -1});
            }
            res.add(mostRecent[0]);
        }  
        return res; 
    }
    
    public void follow(int followerId, int followeeId) {
        // userId-> followeeId
        if (!following.containsKey(followerId)) following.put(followerId, new HashSet<>());     
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // userId -/> followeeId
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
