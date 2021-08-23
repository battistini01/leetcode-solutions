package leetcode;

import java.util.*;
import java.util.stream.Collectors;

class Twitter {

    private Map<Integer, List<Integer>> links;
    private Map<Integer, List<Integer>> tweets;
    private List<Integer> tweetOrder;

    /** Initialize your data structure here. */
    public Twitter() {
        links = new HashMap<>();
        tweets = new HashMap<>();
        tweetOrder = new LinkedList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetOrder.add(tweetId);
        List<Integer> t = tweets.getOrDefault(userId, new LinkedList<>());
        t.add(tweetId);
        tweets.put(userId, t);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> followed = links.getOrDefault(userId, new LinkedList<>()); // followeed list

        List<Integer> userTweets = tweets.entrySet().stream()
                .filter(x -> x.getKey().equals(userId) || followed.contains(x.getKey()))
                .map(Map.Entry::getValue)
                .collect(LinkedList::new, LinkedList::addAll, LinkedList::addAll);

        userTweets.sort((x1, x2) -> tweetOrder.indexOf(x2) - tweetOrder.indexOf(x1));
        List<Integer> sorted = new LinkedList<>(userTweets);

        return sorted.subList(0, sorted.size() >= 10 ? 10 : sorted.size());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
       List<Integer> followeeList = links.getOrDefault(followerId, new LinkedList<>());
       List<Integer> filteredList = followeeList.stream().filter(fId -> fId == followeeId).collect(Collectors.toList());
       if (filteredList.isEmpty())
           followeeList.add(followeeId);
       links.put(followerId, followeeList);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followeeList = links.get(followerId);
        if (followeeList == null) return;
        followeeList = followeeList.stream().filter(x -> x != followeeId).collect(Collectors.toList());
        links.put(followerId, followeeList);
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1,5);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1,2);
        obj.postTweet(2,6);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1,2);
        System.out.println(obj.getNewsFeed(1));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

