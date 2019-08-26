package com.trungthuc.ajax;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import java.io.IOException;

@Controller
public class MusicController {

    @RequestMapping(value = "/music",method = RequestMethod.POST)
    @ResponseBody
    public  Music meth(@RequestBody String  param) throws IOException {

       /* JsonParser parser =new JsonParser();
        JsonElement element=  parser.parse(param);
        JsonObject ob =element.getAsJsonObject();
        Music music =new Music(ob.get("id").getAsInt(),ob.get("name").getAsString(),ob.get("year").getAsString(),ob.get("author").getAsString());*/

       //option 1
        ObjectMapper mapper =new ObjectMapper();
        Music music =mapper.readValue(param,Music.class);

        JsonNode jsonNode = mapper.readTree(param);
        System.out.println("jsonNode object email : " + jsonNode.get("id"));

        return music;
    }

    @GetMapping(value = "/ajax/page")
    public  String toPage(){
        return "ajax/page";
    }
}
