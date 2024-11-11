package designs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Twitter {
    
    class Tweet{
        int userId;
        int tweetId;
        
        public Tweet(int userId,int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    
    List<Tweet> userTweets = null;
    Map<Integer,Set<Integer>> followers = null;
    
    /** Initialize your data structure here. */
    public Twitter() {
        userTweets = new ArrayList<>();
        followers = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userTweets.add(new Tweet(userId,tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be 
     * posted by users who the user followed or by the user herself.Tweets must be ordered from most recent
     * to least recent. */
   
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> result = new ArrayList<>();
        int cnt=10;
        for (int i=userTweets.size() -1; i>=0 && cnt > 0; i--){
            Tweet tweet = userTweets.get(i);
            if (userId == tweet.userId){
                result.add(tweet.tweetId);
            }
            
            if (followers.containsKey(userId)){
                Set<Integer> followeeIds = followers.get(userId);
                if (followeeIds.contains(tweet.userId)){
                    result.add(tweet.tweetId);
                }
            }
            cnt--;
        }
        
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    
        if (followers.containsKey(followerId)){
            followers.get(followerId).add(followeeId);
        }
        else{
            Set<Integer> followeeIds = new HashSet<>();
            followeeIds.add(followeeId);
            followers.put(followerId,followeeIds);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)){
            followers.get(followerId).remove(followeeId);
        }
    }
}

