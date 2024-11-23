package com.perdi.backend.sytempkg;

import java.util.ArrayList;

import com.perdi.backend.postpkg.Post;
import com.perdi.backend.datapkg.DataCenter;
import com.perdi.backend.userpkg.User;

/**
 *  Classe de recomendacao de posts
 *
 * @author arthur
 */

public class Recommendation {
    private static DataCenter dataCenter = DataCenter.getInstance();

    private static double calculateWeeklyRecommendationValue(Post post)
    {
        ArrayList<Post> aux = dataCenter.getPosts();
        double isFriend = 1;
        for(Post p : aux)
        {
            if(p.getPostUserID().equals(post.getPostUserID()))
            {
                isFriend = 1.5;
                break;
            }
        }

        return post.getPostWeeklyViews() * isFriend;
    }

    public static ArrayList<Post> getWeeklyRecommendation(User user)
    {
        ArrayList<PostValue> array = new ArrayList<PostValue>();
        ArrayList<Post> aux = dataCenter.getPosts();
        for (Post p : aux)
        {
            PostValue v = new PostValue(p, calculateWeeklyRecommendationValue(p));
            array.add(v);
        }

        SortPostValue.quickSort(array, 0, array.size() - 1);
        aux = null;

        for (PostValue p : array)
        {
            Post v = p.getPost();
            aux.add(v);
        }

        return aux;
    }


}
