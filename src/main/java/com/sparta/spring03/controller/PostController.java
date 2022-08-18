package com.sparta.spring03.controller;

import com.sparta.spring03.domain.Post;
import com.sparta.spring03.domain.PostRepository;
import com.sparta.spring03.domain.PostRequestDto;
import com.sparta.spring03.domain.PostResponseDto;
import com.sparta.spring03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getPostList(){
        return postService.getPostList();
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id){
        return new PostResponseDto(postService.findPost(id));
    }

    @PostMapping("/posts/{id}")
    public Boolean checkPassword(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        Post post = postService.findPost(id);
        return post.getPassword().equals(requestDto.getPassword());
    }

    @PutMapping("/posts/{id}")
    public PostResponseDto editPost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.editPost(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return "삭제 완료";
    }
}