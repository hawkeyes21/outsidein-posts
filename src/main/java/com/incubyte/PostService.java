package com.incubyte;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PostService {

    private JsonPlaceHolderGateway jsonPlaceHolderGateway;

    public PostService(JsonPlaceHolderGateway jsonPlaceHolderGateway) {
        this.jsonPlaceHolderGateway = jsonPlaceHolderGateway;
    }

    public List<Post> titleContains(String query) {
        List<Post> posts = jsonPlaceHolderGateway.getPosts();
        return posts.stream().filter(post -> post.getTitle().contains(query)).collect(Collectors.toList());

    }

    public List<Post> bodyContains(String query) {
        List<Post> posts = jsonPlaceHolderGateway.getPosts();
        return posts.stream().filter(post -> post.getBody().contains(query)).collect(Collectors.toList());
    }
}
