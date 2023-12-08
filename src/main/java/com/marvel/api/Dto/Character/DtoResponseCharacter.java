package com.marvel.api.Dto.Character;

import com.marvel.api.models.Character;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DtoResponseCharacter {
    private Integer offset;
    private Integer limit;
    private Integer total;
    private Integer count;
    private List<Character> results;
}
