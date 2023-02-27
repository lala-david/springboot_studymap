package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.springframework.http.MediaType;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    private final PostsRepository postsRepository;


    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }


////    @Test
////    @WithMockUser(roles="USER")
////    public void Posts_등록된다() throws Exception {
////
////    }
////
////    @Test
////    @WithMockUser(roles="USER")
////    public void Posts_수정된다() throws  Exception {
//
//    }

}

