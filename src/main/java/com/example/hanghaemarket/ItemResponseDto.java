package com.example.hanghaemarket;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;
    private String msg;


    public ItemResponseDto(Item item){
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }

    public ItemResponseDto(String msg) {
        this.msg = msg;
    }
}
