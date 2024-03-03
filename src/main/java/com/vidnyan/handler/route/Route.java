package com.vidnyan.handler.route;


import com.vidnyan.handler.service.RequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class Route {
    @Bean
    public RouterFunction<ServerResponse> routesFunction(RequestHandler handler) {
        return route(GET("/hello"), handler::hello)
                .andRoute(POST("/data"), handler::setData);
    }
}