package com.trungthuc.daluong;

import lombok.SneakyThrows;

public class RequestHandler  implements Runnable{

    String name;
    public RequestHandler(String name){
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("START ->:" +name + "/" + Thread.currentThread().toString());
         Thread.sleep(500);
        System.out.println("END ->:" +name + "/" + Thread.currentThread().toString());

    }
}
