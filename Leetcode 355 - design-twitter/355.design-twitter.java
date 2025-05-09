/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {

  class Tweets {

    int tweetId;
    int time;

    Tweets(int tweetId, int time) {
      this.tweetId = tweetId;
      this.time = time;
    }
  }

  Map<Integer, List<Tweets>> users;
  Map<Integer, Set<Integer>> followers;
  int time;

  public Twitter() {
    users = new HashMap<>();
    followers = new HashMap<>();
    time = 0;
  }

  public void postTweet(int userId, int tweetId) {
    users
      .computeIfAbsent(userId, k -> new ArrayList<>())
      .add(new Tweets(tweetId, time++));
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Tweets> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

    followers.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

    // Add tweets from user and followers to priority queue
    for (Integer followeeId : followers.get(userId)) {
      List<Tweets> followeeTweets = users.get(followeeId);
      if (followeeTweets != null) {
        pq.addAll(followeeTweets);
      }
    }

    // Get the top 10 tweets
    while (!pq.isEmpty() && result.size() < 10) {
      result.add(pq.poll().tweetId);
    }

    return result;
  }

  public void follow(int followerId, int followeeId) {
    followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    followers.computeIfPresent(
      followerId,
      (k, v) -> {
        v.remove(followeeId);
        return v;
      }
    );
  }

  // Time Complexity: O(n log n)
  // Space Complexity: O(U*T + U*F)
  // where U is the number of users, T is the number of tweets per user,
  // and F is the number of followees per user

  public static void main(String[] args) {
    Twitter twitter = new Twitter();

    twitter.postTweet(1, 5); // null
    System.out.println(twitter.getNewsFeed(1)); // [5]
    twitter.follow(1, 2); // null
    twitter.postTweet(2, 6); // null
    System.out.println(twitter.getNewsFeed(1)); // [6, 5]
    twitter.unfollow(1, 2); // null
    System.out.println(twitter.getNewsFeed(1)); // [5]
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
// @lc code=end
