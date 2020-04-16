package com.trungthuc.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.trungthuc.domains.VanBan;
import com.trungthuc.repositories.VanbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VanBanApi {

    @Autowired
    VanbanRepository vanbanRepository;

    public static List<VanBan> vanBans = new ArrayList<>();

    void  init(){
        for (int i = 0 ; i <= 20 ; i++){
            VanBan vanBan = new VanBan(null, "NAME" + i , "PH"+i);
            vanBans.add(vanBan);
        }
    }


    @GetMapping(value = "/api/call/procedure")
    @ResponseBody
    public  String callExamPle(){
        init();
        try {
            JsonArray result = (JsonArray) new Gson().toJsonTree(vanBans, new TypeToken<List<VanBan>>() {}.getType());
            System.out.printf("JSON ARR: " + result);
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("vanbans",result);
            vanbanRepository.execProcedureTest("123456");
            String params = jsonObject.toString();
            System.out.printf("JSON OBJ: " + jsonObject);
            vanbanRepository.execProcedure( params  );
        //    vanbanRepository.execProcedure( "'" +params +"'"  );
            //JSONObject
           return "OKE";
        }catch (Exception e){
            System.out.printf("EX:-------- "+e.getMessage());
        }
        return "NOTOKE";
    }
}
