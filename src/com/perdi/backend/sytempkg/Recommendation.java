package com.perdi.backend.sytempkg;

import java.util.ArrayList;
import java.util.UUID;

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

    private static double calculateWeeklyRecommendationValue(Post post, User user)
    {
        ArrayList<Post> aux = dataCenter.getPosts();

        double isFriend = 1;
        if(dataCenter.isFollowing(user, post.getPostUserID()))
        {
            isFriend = 1.5;
        }

        return (post.getPostWeeklyViews() + isFriend) * isFriend;
    }

    public static ArrayList<Post> getWeeklyRecommendation(User user)
    {
        ArrayList<PostValue> array = new ArrayList<PostValue>();
        ArrayList<Post> aux = dataCenter.getPosts();
        for (Post p : aux)
        {
            PostValue v = new PostValue(p, calculateWeeklyRecommendationValue(p, user));
            array.add(v);
        }

        array.sort((a,b) -> a.getValue() < b.getValue() ? 1 : -1);

        aux = new ArrayList<Post>();

        for (PostValue p : array)
        {
            Post v = p.getPost();
            aux.add(v);
        }

        return aux;
    }

    private static double calculateAllTimeRecommendationValue(Post post, User user)
    {
        ArrayList<Post> aux = dataCenter.getPosts();

        double isFriend = 1;
        if(dataCenter.isFollowing(user, post.getPostUserID()))
        {
            isFriend = 1.5;
        }

        return (post.getPostWeeklyViews() + isFriend) * isFriend;
    }

    public static ArrayList<Post> getAllTimeRecommendation(User user)
    {
        ArrayList<PostValue> array = new ArrayList<PostValue>();
        ArrayList<Post> aux = dataCenter.getPosts();
        for (Post p : aux)
        {
            PostValue v = new PostValue(p, calculateAllTimeRecommendationValue(p, user));
            array.add(v);
        }

        array.sort((a,b) -> a.getValue() < b.getValue() ? 1 : -1);

        aux = new ArrayList<Post>();

        for (PostValue p : array)
        {
            Post v = p.getPost();
            aux.add(v);
        }

        return aux;
    }
}