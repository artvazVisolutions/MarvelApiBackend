package com.marvel.api.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Event {
    private Integer available;
    private String collectionURI;
    private List<Item> items;
    private Integer returned;
}
