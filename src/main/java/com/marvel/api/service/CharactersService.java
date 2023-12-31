package com.marvel.api.service;

import com.marvel.api.Dto.Character.DtoResponseCharacter;
import com.marvel.api.Dto.Character.ResponseCharacterShort;
import com.marvel.api.utilities.CustomException;

import java.util.List;

public interface CharactersService {

    public List<ResponseCharacterShort> getAllCharacters(String orderBy, Integer offset, Integer limit);
    public ResponseCharacterShort getCharacterById(Integer id) throws CustomException;
}
