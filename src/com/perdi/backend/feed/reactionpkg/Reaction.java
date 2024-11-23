package com.perdi.backend.feed.reactionpkg;

/**
 * @author arthu
 */

import com.perdi.backend.userpkg.User;

public class Reaction {
    private User user;
    private ReactionEnum reaction;

    Reaction(User user, ReactionEnum reaction){
        this.user = user;
        this.reaction = reaction;
    }

    public void setReaction(ReactionEnum reaction)
    {
        this.reaction = reaction;
    }

    public ReactionEnum getReaction()
    {
        return this.reaction;
    }

    public User getUser()
    {
        return this.user;
    }

}