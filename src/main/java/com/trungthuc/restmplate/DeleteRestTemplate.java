package com.trungthuc.restmplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DeleteRestTemplate {

    public static void execRestDelete(String url) {

        try {
            String walletUrl = url;

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(walletUrl)
                    .path("50");

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(builder.toUriString(), (Object) null);
            return;
        } catch (Exception e) {
            System.out.printf("emsg:"+e.getMessage());
        }

    }

    public static void main(String[] args) {
        execRestDelete("https://5c948fcb498269001487f07a.mockapi.io/api/v3/UNITECH/");
    }
}
