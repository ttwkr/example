package com.ssjproject.firstPost.web;

import com.ssjproject.firstPost.domain.posts.Posts;
import com.ssjproject.firstPost.domain.posts.PostsRepository;
import com.ssjproject.firstPost.web.dto.PostsResponseDto;
import com.ssjproject.firstPost.web.dto.PostsSaveRequestDto;
import com.ssjproject.firstPost.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @AfterEach
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        // given
        String title = "제목";
        String content = "내용";
        String author = "ttwkr";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);
    }

    @Test
    public void Posts_수정된다() throws Exception {
        // 일단 저장
        // given
        Posts savedPosts = postsRepository.save(Posts.builder()
                        .title("title")
                        .content("content")
                        .author("ttwkr")
                        .build());

        Long updateId = savedPosts.getId();
        String exceptedTitle = "수정된 타이틀";
        String exceptedContent = "수정된 내용";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(exceptedTitle)
                .content(exceptedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(exceptedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(exceptedContent);
    }

//    @Test
//    public void Post_하나갖고온다() throws Exception {
//        //given
//        Posts savedPost = postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
//                .author("author")
//                .build());
//        Long retrieveId = savedPost.getId();
//        String url = "http://localhost:" + port + "/api/v1/posts/" + retrieveId;
//
//        // when
//        ResponseEntity<PostsResponseDto> responseEntity = restTemplate.getForEntity(url, PostsResponseDto.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
}
