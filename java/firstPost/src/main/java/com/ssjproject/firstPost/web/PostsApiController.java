package com.ssjproject.firstPost.web;

import com.ssjproject.firstPost.domain.posts.Posts;
import com.ssjproject.firstPost.service.posts.PostsService;
import com.ssjproject.firstPost.web.dto.PostsResponseDto;
import com.ssjproject.firstPost.web.dto.PostsSaveRequestDto;
import com.ssjproject.firstPost.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        // PostsSaveRequestDto = django restful framework 의 serializer

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

}
