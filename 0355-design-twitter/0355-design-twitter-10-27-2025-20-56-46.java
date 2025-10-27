class Twitter {
    List<Tweet> tweets;
    Map<Integer, Set<Integer>> map;
    int time;
    public Twitter() {
        tweets = new ArrayList<>();
        map = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId, time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        for(Tweet a : tweets){
            if(
                (
                    userId == a.userId || 
                    (map.containsKey(userId) && map.get(userId).contains(a.userId))
                )
               &&
                (pq.size() < 10 || a.time > pq.peek().time)
            )
            {
                pq.add(a);
                if(pq.size() > 10) pq.poll();
            }
        }
        while(!pq.isEmpty()){
            feed.add(pq.poll().tweetId);
        }
        Collections.reverse(feed);
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(map.get(followerId) == null) map.put(followerId, new HashSet<>());
        map.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(map.get(followerId) == null) return;
        map.get(followerId).remove(followeeId);
    }
}

class Tweet{
    int userId;
    int tweetId;
    int time;

    Tweet(int userId, int tweetId, int time){
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
    }
}


// class Twitter {
//     PriorityQueue<Tweet> pq;
//     Map<Integer, Set<Integer>> map;
//     int time;
//     public Twitter() {
//         pq = new PriorityQueue<>((a, b) -> b.time - a.time);
//         map = new HashMap<>();
//         time = 0;
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         pq.add(new Tweet(userId, tweetId, time));
//         time++;
//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         List<Tweet> temp = new ArrayList<>();
//         List<Integer> feed = new ArrayList<>();

//         while(feed.size() < 10 && !pq.isEmpty()){
//             Tweet t = pq.poll();
//             temp.add(t);
//             if(t.userId == userId || (map.containsKey(userId) && map.get(userId).contains(t.userId))){
//                 feed.add(t.tweetId);
//             }
//         }
//         pq.addAll(temp);
//         return feed;
//     }
    
//     public void follow(int followerId, int followeeId) {
//         if(map.get(followerId) == null) map.put(followerId, new HashSet<>());
//         map.get(followerId).add(followeeId);
//     }
    
//     public void unfollow(int followerId, int followeeId) {
//         if(map.get(followerId) == null) return;
//         map.get(followerId).remove(followeeId);
//     }
// }

// class Tweet{
//     int userId;
//     int tweetId;
//     int time;

//     Tweet(int userId, int tweetId, int time){
//         this.userId = userId;
//         this.tweetId = tweetId;
//         this.time = time;
//     }
// }
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */