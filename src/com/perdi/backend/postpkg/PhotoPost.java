package com.perdi.backend.postpkg;

import java.util.List;

import com.perdi.backend.userpkg.*;


public class PhotoPost extends Post {
    private List<String> urls;

    public PhotoPost(User postUser, String postText, List<String> urls) {
        super(postUser, postText);
        this.urls = urls;
    }

    public List<String> getUrls() { return this.urls; }

    public void setImage(List<String> url_images) { this.urls = url_images; }

    public void addImage(String new_url) {
        this.urls.add(new_url);
    }

    public boolean removeImageByUrl(String url) {
        return this.urls.remove(url);
    }
}
