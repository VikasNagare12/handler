package com.vidnyan.handler.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelErrorHandlingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(Exception.class)
                .handled(true)
                .log(LoggingLevel.ERROR, "Error processing file: ${exception.message}")
                .to("file:/error-directory");
    }
}
