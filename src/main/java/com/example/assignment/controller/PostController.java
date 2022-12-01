package com.example.assignment.controller;

import com.example.assignment.dto.PostListResponseDto;
import com.example.assignment.dto.PostRequestDto;
import com.example.assignment.dto.PostResponseDto;
import com.example.assignment.dto.ResponseDto;
import com.example.assignment.entity.Post;
import com.example.assignment.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PostController {

    private final PostService postService; // service랑 연결할 준비

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }

    @PostMapping("/api/memos")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){

        return postService.createPost(requestDto);
    }

    @PostMapping("/save/post")
    public ResponseDto savePost(@RequestBody PostRequestDto requestDto){

        return postService.savePost(requestDto);
    }

    @GetMapping("/api/memos")
    public List<Post> getMemos(){
        return postService.getPost();
    }

    @PutMapping("/api/memos/{id}")
    public Long updatePost(@PathVariable Long id,@RequestBody PostRequestDto requestDto){
        return postService.update(id,requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }




//    @GetMapping("/api/posts")
//    public PostListResponseDto getPost(){
//        return postService.getPost();
//    }


}
