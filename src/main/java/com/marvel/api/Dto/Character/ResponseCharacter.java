package com.marvel.api.Dto.Character;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseCharacter {
    private Integer code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private DtoResponseCharacter data;
}
