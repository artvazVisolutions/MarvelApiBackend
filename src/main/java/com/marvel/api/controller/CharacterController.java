package com.marvel.api.controller;

import com.marvel.api.Dto.Character.DtoResponseCharacter;
import com.marvel.api.Dto.Character.ResponseCharacterShort;
import com.marvel.api.service.CharactersService;
import com.marvel.api.utilities.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private CharactersService service ;

    @Autowired
    public CharacterController(CharactersService service){
        this.service = service;
    }

    @GetMapping("/character")

        public ResponseEntity<List<ResponseCharacterShort>> getAllCharacters(@RequestParam(required = false) String orderBy,
                @RequestParam(required = false) Integer offset,
                @RequestParam(required = false) Integer limit){
        return new ResponseEntity<List<ResponseCharacterShort>>(service.getAllCharacters(orderBy,offset,limit), HttpStatus.OK);
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<?> getCharacterById(@PathVariable Integer id) throws CustomException {
        try {
            return new ResponseEntity<ResponseCharacterShort>(service.getCharacterById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
        }
    }


}
