package com.blogapi.blogpost.controller;

import com.blogapi.blogpost.model.BlogPost;
import com.blogapi.blogpost.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/posts")
    public List<BlogPost> getAllBlogPosts()
    {
        return blogPostService.getAllBlogPosts();
    }

    @RequestMapping(method = RequestMethod.POST, value="/posts")
    public void addBlogPost(@RequestBody BlogPost blogPost)
    {
        blogPostService.addBlogPost(blogPost);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/posts/{id}")
    public void updateSubject(@PathVariable Long id, @RequestBody BlogPost blogPost)
    {
        blogPostService.updateBlogPost(id, blogPost);
    }


    @RequestMapping("/posts/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPostService.getBlogPostById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/posts/{id}")
    public void deleteBlogPost(@PathVariable Long id)
    {
        blogPostService.deleteBlogPost(id);
    }
}

