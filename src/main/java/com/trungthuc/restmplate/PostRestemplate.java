package com.trungthuc.restmplate;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class PostRestemplate {

    public static JSONObject execRestPost(String url){

        try {
            String walletBalanceUrl = url;

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Authorization ", "eyfsdfdsf");

            JSONObject json = new JSONObject();
            json.put("email", "jiween@gmail.com");
            json.put("password", "jiween12345");

            HttpEntity<String> httpEntity = new HttpEntity <String> (json.toString(), httpHeaders);

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.postForObject(walletBalanceUrl, httpEntity, String.class);

            JSONObject jsonObj = new JSONObject(response);
            //String balance = jsonObj.get("data").toString();
            return jsonObj;
        }catch (Exception e){
            System.out.printf("mesg:"+e.getMessage());
        }

        return null;

    }

    public static void main(String[] args) {
        String url = "http://admin.smartkiosk.kr:8080/api/account/create";
        JSONObject jsonObject = execRestPost(url);

    }


}
