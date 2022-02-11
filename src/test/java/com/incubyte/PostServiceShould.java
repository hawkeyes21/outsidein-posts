package com.incubyte;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceShould {

    @Mock
    JsonPlaceHolderGateway jsonPlaceHolderGateway;
    PostService postService;

    @BeforeEach
    public void init() {
        postService = new PostService(jsonPlaceHolderGateway);
        Post post1 = new Post();
        post1.setUserId("1");
        post1.setTitle("does this post have 'ese qui'?");
        post1.setBody("bhsbhsbchbch ese qui ncjncjdcnj");
        Post post2 = new Post();
        post2.setUserId("2");
        post2.setTitle("this post has 'qui ese' in it.........");
        post2.setBody("This post does not contains 'qui ese'");

        List<Post> posts = List.of(post1, post2);
        when(jsonPlaceHolderGateway.getPosts()).thenReturn(posts);

    }

    @Test
    public void find_the_posts_with_the_given_query_contents_in_title() {
        List<Post> posts = postService.titleContains("ese qui");
        verify(jsonPlaceHolderGateway).getPosts();
        Assertions.assertEquals(1, posts.size());
    }

    @Test
    public void find_the_posts_with_the_given_query_contents_in_body() {
        List<Post> posts = postService.bodyContains("ese qui");
        verify(jsonPlaceHolderGateway).getPosts();
        Assertions.assertEquals(1, posts.size());
    }
}
