package com.marvel.api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Comic {
    private Integer available;
    private String collectionURI;
    private List<Item> items;
    private Integer returned;

}
