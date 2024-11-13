package com.perdi.backend.postpkg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.userpkg.*;


public class PhotoPost extends Post {
    private List<String> urls;

    public PhotoPost(User postUser, List<String> urls) {
        super(postUser);
        this.urls = urls;
    }
    public PhotoPost(User postUser, Group postGroup, List<String> urls) {
        super(postUser, postGroup);
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

    public String toString() {
        return "PotoPhost{" +
                "urls=" + urls +
                ", postUser=" + getPostUser() +
                ", postGroup=" + getPostDomain() +
                ", createdAt= " + getPostCreationDate() +
                "}";
    }
}

