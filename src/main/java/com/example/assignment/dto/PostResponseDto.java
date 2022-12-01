package com.example.assignment.dto;

import com.example.assignment.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class PostResponseDto {
    private String title;
    private String contents;
    private String author;
    private String password;

    public PostResponseDto (Post ps){
        this.title = ps.getTitle();
    }
}
