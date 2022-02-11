package com.incubyte;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PostControllerShould {

    @Mock
    PostService postService;

    @Test
    public void find_the_title_with_given_query_contents() {
        PostController controller = new PostController(postService);
        List<Post> posts = controller.getSearchInTitle("qui est");
        verify(postService).titleContains("qui est");
    }
    @Test
    public void find_the_body_with_given_query_contents() {
        PostController controller = new PostController(postService);
        List<Post> posts = controller.getSearchInBody("qui est");
        verify(postService).bodyContains("qui est");
    }

}
