package com.perdi.backend.feed.postpkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class PhotoPost extends Post {
    private List<String> urls;

    // public PhotoPost() {}

    public PhotoPost(UUID postUserID) {
        super(postUserID);
        this.urls = new ArrayList<>();
    }

    public PhotoPost(UUID postUserID, UUID postGroupID, List<String> urls) {
        super(postUserID, postGroupID);
        setImage(urls);
    }

    @Override
    public Object getContent() { return urls; }

    @Override
    public void setContent(Object content) {
        if (content instanceof List<?> list && list.stream().allMatch(item -> item instanceof String)) {
            setImage((List<String>) list);
            markAsEdited();
        } else {
            System.out.println("Conteudo Invalido");
        }
    }

    public List<String> getUrls() { return Collections.unmodifiableList(this.urls); }

    public void setImage(List<String> url_images) {
        if (url_images != null) {
            this.urls = new ArrayList<>(url_images);
        }
    }

    public void addImage(String new_url) {
        if (new_url != null && !new_url.isEmpty()) {
            this.urls.add(new_url);
        }
    }

    public boolean removeImageByUrl(String url) {
        return this.urls.remove(url);
    }

    private String returnUrls() {
        String string = "";

        for (String url : this.urls) {
            string = string.concat(url);
        }

        return string;
    }

    @Override
    public String toString() {
        return "PotoPhost{" +
                "urls=" + returnUrls() +
                ", postUser=" + getPostUserID() +
                ", postGroup=" + getPostDomain() +
                ", createdAt= " + getPostCreationDate() +
                "}";
    }
}

