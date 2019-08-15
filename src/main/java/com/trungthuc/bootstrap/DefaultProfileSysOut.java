package com.trungthuc.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "prod")
public class DefaultProfileSysOut {

    @Autowired
    public DefaultProfileSysOut(@Value("${com.trung.thuc}") String msg){
        System.out.println("########################### ");
        System.out.println("########################### ");
        System.out.println("###          DEV :"+msg+":         ## ");
        System.out.println("########################### ");
        System.out.println("########################### ");
    }
}
