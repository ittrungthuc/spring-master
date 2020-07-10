package com.trungthuc.optional;

import java.util.Optional;

public class  step1 {
    public static void main(String[] args) {
       /* Optional<String> data;
        Optional<String> data1= Optional.of("data");
        Optional<String> optional = Optional.ofNullable(data);
        ///System.out.println(data.get());
        System.out.println(data1.get());*/
        strudent df= getSD();
        Optional<strudent> op =Optional.ofNullable(df);
        System.out.println("te() = " + te());

    }
    public static String te(){
        strudent df= getSD();
        Optional<strudent> op =Optional.ofNullable(df);
        System.out.println("op.filter" + op.filter(o -> o.getCode().equalsIgnoreCase("thuc")));
        return op.map(strudent::getCode).orElse("not fould");
    }

    public  static strudent getSD(){
        strudent bv =new strudent();
        bv.setId(1);
        bv.setName("thuc");
        bv.setCode("tu");
        return bv;
    }
}
