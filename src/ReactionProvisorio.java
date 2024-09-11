/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class ReactionProvisorio{
    private User user;
    private EnumReactionsProvisorio reaction;

    ReactionProvisorio(User user, EnumReactionsProvisorio reaction)
    {
        this.user = user;
        this.reaction = reaction;
    }

    public void setReaction(EnumReactionsProvisorio reaction)
    {
        this.reaction = reaction;
    }

    public EnumReactionsProvisorio getReaction()
    {
        return this.reaction;
    }

    public User getUser()
    {
        return this.user;
    }

}