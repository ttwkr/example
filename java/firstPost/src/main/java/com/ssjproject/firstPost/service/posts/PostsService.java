package com.ssjproject.firstPost.service.posts;

import com.ssjproject.firstPost.domain.posts.Posts;
import com.ssjproject.firstPost.domain.posts.PostsRepository;
import com.ssjproject.firstPost.web.dto.PostsResponseDto;
import com.ssjproject.firstPost.web.dto.PostsSaveRequestDto;
import com.ssjproject.firstPost.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
