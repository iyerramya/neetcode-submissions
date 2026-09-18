class Twitter {
    int tweetOrderId;
    Map<Integer, List<Tweet>> userIdToTweets;
    Map<Integer, Set<Integer>> followerIdToFolowees;

    public Twitter() {
        this.userIdToTweets = new HashMap<>();
        this.followerIdToFolowees = new HashMap<>();
        this.tweetOrderId = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userIdToTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, getTweetOrderId()));
        followerIdToFolowees.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> (t1.tweetOrderId - t2.tweetOrderId));
        List<Integer> res = new ArrayList<>();
        if(!followerIdToFolowees.containsKey(userId)) {
            return res;
        }
        for(int followees: followerIdToFolowees.get(userId)) {
            for(Tweet tweet : userIdToTweets.get(followees)) {
                pq.offer(tweet);
                if(pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        while (!pq.isEmpty()) {
            res.add(0,pq.poll().tweetId);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followerIdToFolowees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerIdToFolowees.containsKey(followerId)) {
            if(followerIdToFolowees.get(followerId).contains(followeeId)) {
                followerIdToFolowees.get(followerId).remove(followeeId);
            }
        }    
    }

    private int getTweetOrderId() {
        return this.tweetOrderId++;
    }

    class Tweet {
        int tweetId;
        int tweetOrderId;

        public Tweet(int tweetId, int tweetOrderId) {
            this.tweetId = tweetId;
            this.tweetOrderId = tweetOrderId;
        }
    }
}
