/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class ReactionProvisorio{
    private User user;
    private reactionsProvisorio reaction;

    ReactionProvisorio(User user, reactionsProvisorio reaction)
    {
        this.user = user;
        this.reactionsProvisorio = reaction;
    }

    public void setReaction(reactionsProvisorio reaction)
    {
        this.reaction = reaction;
    }

    public reactionsProvisorio getReaction()
    {
        return this.reaction;
    }

    public User getUser()
    {
        return this.user;
    }

}