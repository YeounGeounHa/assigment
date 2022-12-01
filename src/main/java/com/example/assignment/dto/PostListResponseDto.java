package com.example.assignment.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PostListResponseDto extends ResponseDto{

    List<PostResponseDto> PostList = new ArrayList<>();

    public PostListResponseDto(){
        super("강의 목록 조회 성공", HttpStatus.OK.value());
    }

    public void addPost(PostResponseDto responseDto) {
        PostList.add(responseDto);
    }
}
