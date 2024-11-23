package com.perdi.backend.systempkg.reccomendationpkg;

import com.perdi.backend.feed.postpkg.Post;

public class PostValue {
    private Post post;
    private double value;

    PostValue(Post post, double value)
    {
        this.post = post;
        this.value = value;
    }

    public double getValue()
    {
        return value;
    }

    public Post getPost()
    {
        return post;
    }
}
