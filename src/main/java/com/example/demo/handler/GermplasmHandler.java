package com.example.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.to.Germplasm;

import reactor.core.publisher.Mono;

@Component
public class GermplasmHandler {
    public Mono<ServerResponse> getGermplasm(ServerRequest request) {
        int id = Integer.parseInt(request.queryParam("id").orElse("0"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Germplasm(id , "germ-name-" + id)));
    }
}
