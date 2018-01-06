package com.crud.tasks.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.username}")
    private String trelloUserName;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Autowired
    private RestTemplate restTemplate;

    private URI getUrl() {
        //podstawowa wersja
        //TrelloBoardDto[] boardsResponse = restTemplate.getForObject("https://api.trello.com/1/members/michamichalik2/boards" + "?key" + trelloAppKey + "&token=" + trelloToken, TrelloBoardDto[].class);

        //lub z wykorzystaniem Uri class
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUserName + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id").build().encode().toUri();
    }

    public List<TrelloBoardDto> getTrelloBoards() {

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(getUrl(), TrelloBoardDto[].class);

        return Arrays.asList(Optional.ofNullable(boardsResponse).orElse(new TrelloBoardDto[0])); // <-- zadanie 18.2.4
    }
}
