package com.devstromo.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookType {
    private final String type;
    private final String distributor;
    private final String otherData;
}
