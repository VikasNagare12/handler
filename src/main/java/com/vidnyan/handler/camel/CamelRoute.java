package com.vidnyan.handler.camel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/input-directory")
                .routeId("fileRoute")
                .log("Received file: ${header.CamelFileName}")
                .to("direct:processFile");

        from("direct:processFile")
                .routeId("processFileRoute")
                .bean(FileProcessor.class)
                .to("file:/output-directory");
    }
}
