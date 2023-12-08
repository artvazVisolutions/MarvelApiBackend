package com.marvel.api.service.Impl;

import com.marvel.api.Dto.Character.DtoResponseCharacter;
import com.marvel.api.Dto.Character.ResponseCharacter;
import com.marvel.api.Dto.Character.ResponseCharacterShort;
import com.marvel.api.models.Character;
import com.marvel.api.service.CharactersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.marvel.api.utilities.getMD5.getMD5;

@Service
public class CharactersServiceImpl implements CharactersService {

    RestTemplate restTemplate = new RestTemplate();
    String publicKey = "15e0250b263b6e7b9922dbd0e3a0d380";
    String privateKey = "3270d7caecd142d7a4f749c48aad129cfdfe028c";
    long timestamp = System.currentTimeMillis();
    String apiUrl = "https://gateway.marvel.com:443/v1/public/characters";

    @Override
    public List<ResponseCharacterShort> getAllCharacters(String orderBy,Integer offset,Integer limit) {
        String paramsUrl = apiUrl+"?";
        if(orderBy != null)
            paramsUrl+="orderBy="+orderBy+"&";
        if(offset != null)
            paramsUrl +="offset="+offset+"&";
        if(limit != null)
            paramsUrl += "limit"+limit+"&";
        String hash = getMD5(timestamp+privateKey+publicKey);
        String url = String.format("%sts=%s&apikey=%s&hash=%s",paramsUrl,timestamp,publicKey,hash);
        ResponseEntity<ResponseCharacter> res = restTemplate.getForEntity(url, ResponseCharacter.class);

        DtoResponseCharacter character = Objects.requireNonNull(res.getBody()).getData();
        List <ResponseCharacterShort> list = new ArrayList<>();
        if(res.getStatusCode().is2xxSuccessful())
            character.getResults().forEach( item ->{
                ResponseCharacterShort characterTemp = new ResponseCharacterShort(item.getId(),item.getName(),item.getDescription());
                list.add(characterTemp);
            });
        return list;

    }

    @Override
    public ResponseCharacterShort getCharacterById(Integer id) {
        String hash = getMD5(timestamp+privateKey+publicKey);
        String url = String.format("%s/%s?ts=%s&apikey=%s&hash=%s",apiUrl,id,timestamp,publicKey,hash);
        ResponseEntity<ResponseCharacter> res = restTemplate.getForEntity(url, ResponseCharacter.class);
        DtoResponseCharacter character = Objects.requireNonNull(res.getBody()).getData();

        ResponseCharacterShort response = null;
        if(res.getStatusCode().is2xxSuccessful()) {
            for (Character item : character.getResults()) {
                response = new ResponseCharacterShort(item.getId(), item.getName(), item.getDescription());
            }
        }
        return response;
    }
}
