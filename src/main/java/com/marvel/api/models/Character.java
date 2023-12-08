package com.marvel.api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Character {

    private Integer id;
    private String name;
    private String description;
    private String modified;
    private Tumbnail thumbnail;
    private String resourceURI;
    private Comic comics;
    private Serie series;
    private Story stories;
    private Event events;
    private List<Url> urls;

}
