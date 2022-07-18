package com.ssjproject.firstPost.service.posts;

import com.ssjproject.firstPost.domain.posts.Posts;
import com.ssjproject.firstPost.domain.posts.PostsRepository;
import com.ssjproject.firstPost.web.dto.PostsResponseDto;
import com.ssjproject.firstPost.web.dto.PostsSaveRequestDto;
import com.ssjproject.firstPost.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        return new PostsResponseDto(entity);
    }

    public List<PostsResponseDto> list(){
        List<Posts> postsList = postsRepository.findAll();

        return postsList.stream().map(posts -> new PostsResponseDto(posts)).collect(Collectors.toList());

    }

    public Long delete(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
        postsRepository.delete(post);
        return id;
    }
}
