package com.perdi.backend.userpkg;

public interface BlockManager {
    boolean blockUser(User blocker, User toBlock);
    boolean unblockUser(User blocker, User toUnblock);
    boolean isUserBlocked(User blocker, User toCheck);
}
