package com.vidnyan.handler.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.swing.plaf.PanelUI;

@Service
public class RequestHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().bodyValue("Hello, WebFlux!");
    }

    public Mono<ServerResponse> setData(ServerRequest request) {
        Mono<String> dataMono = request.bodyToMono(String.class);
        return ServerResponse.ok().bodyValue("Hellow Vikas ");
    }
}
