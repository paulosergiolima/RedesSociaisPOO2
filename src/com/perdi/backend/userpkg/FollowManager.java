package com.perdi.backend.userpkg;

public interface FollowManager {
    boolean follow(User follower, User following);
    boolean unfollow(User follower, User following);
    boolean removeFollower(User user, User follower);
    int getFollowersCount(User user);
    int getFollowingCount(User user);
}
