package com.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/posts")
public class PostController {
    @Inject
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Get("/titleContains")
    public List<Post> getSearchInTitle(@QueryValue String q) {
        return postService.titleContains(q);
    }

    @Get("/bodyContains")
    public List<Post> getSearchInBody(@QueryValue String q) {
     return postService.bodyContains(q);
    }
}
