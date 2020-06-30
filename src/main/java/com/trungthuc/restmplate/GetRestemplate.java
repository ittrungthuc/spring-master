package com.trungthuc.restmplate;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GetRestemplate {

    public static Object[] execRestGet(String url) {

        try {
            String transactionUrl = url;

            UriComponentsBuilder builder = UriComponentsBuilder
                    .fromUriString(transactionUrl);
                    // Add query parameter
//                    .queryParam("pageNumber", "1")
//                    .queryParam("walletId", "2323JK")
//                    .queryParam("pageSize", "10");

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(builder.toUriString(), Object[].class);
            Object[] objects = responseEntity.getBody();
            return  objects;
        } catch (Exception e) {
            System.out.printf("emsg:"+e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        String url = "https://5c948fcb498269001487f07a.mockapi.io/api/v3/UNITECH";
        Object[] jsonArray = execRestGet(url);
        String res = jsonArray.toString();
    }
}
