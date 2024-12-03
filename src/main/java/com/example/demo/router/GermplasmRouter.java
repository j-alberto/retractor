package com.example.demo.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.handler.GermplasmHandler;

@Configuration(proxyBeanMethods = false)
public class GermplasmRouter {
    @Bean
    RouterFunction<ServerResponse> route(GermplasmHandler germplasmHandler) {
        return RouterFunctions.route(
                GET("/germ").and(accept(MediaType.APPLICATION_JSON)), germplasmHandler::getGermplasm);
    }
}
