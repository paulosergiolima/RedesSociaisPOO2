package com.perdi.backend.systempkg.reccomendationpkg;

import java.util.ArrayList;

import com.perdi.backend.feed.postpkg.Post;
import com.perdi.backend.storage.datapkg.DataCenter;
import com.perdi.backend.userpkg.User;

/**
 *  Classe de recomendacao de posts
 *
 * @author arthur
 */

/*
 *      Modelo do comentario:
 *      Como deve ser usado no codigo
 *          descricao da funcao
 *
 *      ArrayList<Post> recomendacoes = Recommendation.getWeeklyRecommendation(User);
 *          retorna um array de posts ordenados na ordem de "importancia semanal" para o usuario
 *
 *      ArrayList<Post> recomendacoes = Recommendation.getWeeklyRecommendation(User);
 *          retorna um array de posts ordenados na ordem de "importancia desde o comeco" para o usuario
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
        //Eu nao sei oq eh isso, mas o importante eh que parece que esta funcionando e isso eh tudo que importa
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
