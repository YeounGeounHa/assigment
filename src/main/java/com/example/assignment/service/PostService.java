package com.example.assignment.service;

import com.example.assignment.dto.PostRequestDto;
import com.example.assignment.dto.PostResponseDto;
import com.example.assignment.dto.ResponseDto;
import com.example.assignment.entity.Post;
import com.example.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;//데이터베이스와 소통하는 부분?

@Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {

        Post post=new Post(requestDto);
        postRepository.save(post);
        PostResponseDto responseDto =  new PostResponseDto(post);
        return responseDto;

    }

@Transactional(readOnly = true)
    public List<Post> getPost() {
    return postRepository.findAllByOrderByModifiedAtDesc();
}
@Transactional
    public ResponseDto savePost(PostRequestDto requestDto) {
    Post post=new Post(requestDto);
    postRepository.save(post);
    return new ResponseDto("게시글 작성", HttpStatus.OK.value());

    }

@Transactional
    public Long update(Long id, PostRequestDto requestDto) {
    Post post = postRepository.findById(id).orElseThrow(
            ()->new IllegalStateException("아이디가 존재하지 않습니다")
    );
    post.upadte(requestDto);
    return post.getId();
    }
@Transactional
    public Long deletePost(Long id) {
    postRepository.deleteById(id);
    return id;
    }
}
