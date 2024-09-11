/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class PostWithReaction{
    private ArrayList<Reaction> reactions;

    PostWithReaction()
    {
        this.reactions = new ArrayList<Reaction>();
    }

    //getters
    public int getNumberOfLikes()
    {
        int result = 0;
        for(Reaction reactionElement: reactions)
        {
            if(reactionElement.getReaction().equals(EnumReactionsProvisorio.LIKE))
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
            if(reactionElement.getReaction().equals(EnumReactionsProvisorio.LOVED))
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
            if(reactionElement.getReaction().equals(EnumReactionsProvisorio.DISLIKE))
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
            if(reactionElement.getReaction().equals(EnumReactionsProvisorio.HATED))
            {
                result++;
            }
        }
        return result;
    }

    //Button actions
    public void activateReaction(User user, EnumReactionsProvisorio reaction)
    {
        boolean flag = true;
        for(int i = 0; i < reactions.size() && flag; i++)
        {
            if(reactions.get(i).getUser().getUserName().equals(user.getUserName()))
            {
                if(reactions.get(i).getReaction().equals(reaction))
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
            ReactionsProvisorio newReaction = new ReactionProvisorio(user, reaction);
            reactions.add(newReaction);
        }
    }
}