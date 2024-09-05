/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class PostWithReaction{
    private ArrayList<Reaction> reactions;

    //getters
    public int getNumberOfLikes()
    {
        int result = 0;
        for(Reaction reactionElement: reactions)
        {
            if(reactionElement.getReaction() == reactionsProvisorio.like)
            {
                result++;
            }
        }
        return result;
    }

    public int getNumberOfLoved()
    {
        int result = 0;
        for(Reaction reactionElement: reactions)
        {
            if(reactionElement.getReaction() == reactionsProvisorio.loved)
            {
                result++;
            }
        }
        return result;
    }

    public int getNumberOfDislikes()
    {
        int result = 0;
        for(Reaction reactionElement: reactions)
        {
            if(reactionElement.getReaction() == reactionsProvisorio.dislike)
            {
                result++;
            }
        }
        return result;
    }

    public int getNumberOfHated()
    {
        int result = 0;
        for(Reaction reactionElement: reactions)
        {
            if(reactionElement.getReaction() == reactionsProvisorio.hated)
            {
                result++;
            }
        }
        return result;
    }

    //Button actions
    public void activateReaction(User user, reactionsProvisorio reaction)
    {
        boolean flag = true;
        for(int i = 0; i < reactions.size() && flag; i++)
        {
            if(reactions.get(i).getUser().getUserName().equals(user.getUserName()))
            {
                if(reactions.get(i).getReaction() == reaction)
                {
                    reactions.remove(i)
                }
                else
                {
                    reactions.get(i).setReaction(reaction);
                }
                flag = false;
            }
        }
        if(flag)
        {
            ReactionProvisorio newReaction = new ReactionProvisorio(user, reaction);
            reactions.add(newReaction);
        }
    }
}