package com.perdi.backend.postpkg;

import java.time.LocalDateTime;
import java.util.ArrayList;

import User;


public class PhotoPost extends PostWithCommentSection {
    private ArrayList<String> urls;

    public PhotoPost(User postUser, String postText, ArrayList<String> urls) {
        super(postUser, postText);
        this.urls = urls;
    }

    public ArrayList<String> getUrls() { return this.urls; }
    public void setImage(ArrayList<String> url_images) { this.urls = url_images; }

    public int getImageIndex(String url) {
        for (int i = 0; i < urls.size(); i++) {
            if (url.equals(urls.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public void addImage(String new_url) {
        urls.add(new_url);
    }

    public boolean removeImageByIndex(int index) {
        if (index >= 0 && index < urls.size()) {
            urls.remove(index);
            return true;
        }
        return false;
    }

    public boolean removeImageByUrl(String url) {
        int index = this.getImageIndex(url);
        return this.removeImageByIndex(index);
    }
}
