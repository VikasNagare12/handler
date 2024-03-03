package com.vidnyan.handler.sender;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class RestClientSender {


    RestClient restClient = RestClient.create();
    public String getRequest(String url){
        String result = restClient.get()
                .uri(url)
                .retrieve()
                .body(String.class);
        System.out.println(result);
        return result;
    }



    public String postRequest(String url){
        ResponseEntity<Void> response = restClient.post()
                .uri(url)
                .contentType(APPLICATION_JSON)
                .body("data")
                .retrieve()
                .toBodilessEntity();
        return "";
    }


}
