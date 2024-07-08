package com.example.hanghaemarket;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemRequestDto {
    private String username;
    private String title;
    private String content;
    private int price;

}
