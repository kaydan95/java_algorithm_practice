package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Item {
    private int code = 0;
    private String name = null;
    private String text = null;
    private int price = 0;
    private long quantity = 0L; 
}
