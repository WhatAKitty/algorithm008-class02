import java.util.*;
import java.util.stream.Collectors;

/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 *
 * <code>
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 * </code>
 *
 * @author WhatAKitty
 * @date 2020/04/19
 * @since 1.0.0
 **/
public class Twitter {

    private static final List<Integer> EMPTY_LIST = new ArrayList<>(0);
    private static final Tweet HEAD = new Tweet(-1, -1, -1);

    // 用户与关注人的映射关系
    private final Map<Integer, List<Integer>> userAndFollowersMapping = new HashMap<>(128);
    private final Map<Integer, Tweet> userAndTweetsMapping = new HashMap<>(1024);
    private final Map<Integer, Tweet> cloned = new HashMap<>(1024);

    private long timestamp = 0L;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        userAndTweetsMapping.compute(userId, (uid, head) -> {
            Tweet newHead = new Tweet(tweetId, uid, timestamp++);
            if (head == null) {
                return newHead;
            }

            newHead.next = head;
            return newHead;
        });
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        cloned.clear();
        cloned.putAll(userAndTweetsMapping);

        List<Integer> userIds = userAndFollowersMapping.getOrDefault(userId, new ArrayList<>(1));
        userIds.add(userId);

        List<Tweet> result = new LinkedList<>();
        for (; ; ) {
            if (result.size() > 9) {
                break;
            }

            boolean allEmpty = true;
            Tweet max = HEAD;
            for (int uid : userIds) {
                Tweet tweet = cloned.get(uid);
                if (tweet == null) {
                    continue;
                }
                allEmpty = false;

                if (max.timestamp < tweet.timestamp) {
                    max = tweet;
                }
            }

            if (max != HEAD) {
                result.add(max);
                cloned.put(max.userId, max.next);
            }

            if (allEmpty) {
                break;
            }
        }

        return result.stream().map(item -> item.id).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        userAndFollowersMapping.compute(followerId, (fid, followers) -> {
            if (followers == null) {
                followers = new ArrayList<>(16);
            }

            followers.add(followeeId);
            return followers;
        });
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        userAndFollowersMapping.compute(followerId, (fid, followers) -> {
            if (followers == null) {
                return new ArrayList<>();
            }

            followers.removeIf(i -> i.equals(followeeId));
            return followers;
        });
    }

    static class Tweet {

        private int id;
        private int userId;
        private long timestamp;

        private Tweet next;

        public Tweet(int id, int userId, long timestamp) {
            this.id = id;
            this.userId = userId;
            this.timestamp = timestamp;
        }

    }

}
