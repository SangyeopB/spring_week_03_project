package com.sparta.spring03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령
    private Long id;

    @Column
    private String title;

    @Column
    private String writer;

    @Column
    private String content;

    @Column
    private String password;

    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
