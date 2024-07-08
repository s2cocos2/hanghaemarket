package com.example.hanghaemarket;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class ItemController {

    private final ItemService itemService;

    //판매 게시글 작성
    @PostMapping("")
    public ItemResponseDto createPost(@RequestBody ItemRequestDto requestDto){
        return itemService.createPost(requestDto);
    }

    //판매 게시글 전체 리스트 조회
    @GetMapping("")
    public List<ItemResponseDto> getAllPosts(){
        return itemService.getAllPosts();
    }

    //판매 게시글 수정
    @PutMapping("/{id}")
    public ItemResponseDto updatePost(@PathVariable Long id, @RequestBody ItemRequestDto requestDto){
        return itemService.updatePost(id, requestDto);
    }


    //게시글 삭제
    @DeleteMapping("/{id}")
    public ItemResponseDto deletePost(@PathVariable Long id) {
        return itemService.deletePost(id);
    }


}
