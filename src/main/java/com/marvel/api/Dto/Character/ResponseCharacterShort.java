package com.marvel.api.Dto.Character;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseCharacterShort {
    private Integer id;
    private String name;
    private String description;

    public ResponseCharacterShort(Integer id, String name, String description){
        this.id = id;
        this.name = name;
        this.description =description;
    }

}
