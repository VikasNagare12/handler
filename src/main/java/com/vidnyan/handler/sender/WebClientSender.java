package com.vidnyan.handler.sender;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class WebClientSender {


    private final WebClient webClient = WebClient.create("http://example.com");

    public Mono<Void> setRequest(Mono<String> dataMono) {
        return dataMono.flatMap(data -> webClient.post()
                .uri("/data")
                .bodyValue(data)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnError(WebClientResponseException.class, e -> log.error(e.getMessage(), e)));
    }


}

