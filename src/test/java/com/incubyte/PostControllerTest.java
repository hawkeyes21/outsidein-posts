package com.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class PostControllerTest {

    @Inject
    @Client("/")
    HttpClient client;


    @Test
    public void get_posts_by_contents_of_the_title() {
        List<Map> posts = client
                .toBlocking()
                .retrieve(HttpRequest.GET("/posts/titleContains?q=" + URLEncoder.encode("qui est", StandardCharsets.UTF_8)), Argument.listOf(Map.class));
        Assertions.assertFalse(posts.isEmpty());

        assertEquals("1", posts.get(0).get("userId"));
        assertEquals("qui est esse", posts.get(0).get("title"));
    }


    @Test
    public void get_posts_by_contents_of_the_body() {
        List<Map> posts = client
                .toBlocking()
                .retrieve(HttpRequest.GET("/posts/bodyContains?q=" + URLEncoder.encode("rerum tempore", StandardCharsets.UTF_8)), Argument.listOf(Map.class));
        Assertions.assertFalse(posts.isEmpty());
        assertEquals("1", posts.get(0).get("userId"));
        assertTrue( ((String)posts.get(0).get("body")).contains("rerum tempore"));
    }
}
