package com.example.hanghaemarket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto createPost(ItemRequestDto requestDto) {
        Item item = itemRepository.save(new Item(requestDto));
        return new ItemResponseDto(item);
    }

    @Transactional(readOnly = true)
    public List<ItemResponseDto> getAllPosts() {
        return itemRepository.findAll().stream()
                .map(ItemResponseDto::new)
                .collect(Collectors.toList());
    }

    public ItemResponseDto updatePost(Long id, ItemRequestDto requestDto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        item.update(requestDto);
        item = itemRepository.save(item);
        return new ItemResponseDto(item);
    }

    public ItemResponseDto deletePost(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        itemRepository.delete(item);
        return new ItemResponseDto("삭제완료");
    }
}
