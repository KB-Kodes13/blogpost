package com.blogapi.blogpost.service;

import com.blogapi.blogpost.model.BlogPost;
import com.blogapi.blogpost.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BlogPostService {

    @Autowired
    public BlogPostRepository blogPostRepository;


    public void addBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);

    }

    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) {
        BlogPost existingBlogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog post id: " + id));

        existingBlogPost.setTitle(updatedBlogPost.getTitle());
        existingBlogPost.setContent(updatedBlogPost.getContent());
        existingBlogPost.setAuthor(updatedBlogPost.getAuthor());

        return blogPostRepository.save(existingBlogPost);
    }




    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);

    }

    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> posts = new ArrayList<>();
        blogPostRepository.findAll().forEach(posts::add);
        return posts;
    }

    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog post id: " + id));
    }

}

