package com.trungthuc.controllers;

import java.util.HashMap;

public abstract class AbtractController {

  protected String StringcheckHepper(HashMap<String,Object> res,String string){
        if (res.get(string)!=null && !"".equals(res.get(string))){
            return res.get(string).toString();
        }else{
            return "";
        }

    }
    protected int IntcheckHepper(HashMap<String,Object> res,String string){
        if (res.get(string)!=null && !"".equals(res.get(string))){
            return Integer.valueOf(res.get(string).toString());
        }else{
            return 0;
        }

    }
}
