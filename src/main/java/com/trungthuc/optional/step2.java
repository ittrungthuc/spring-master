package com.trungthuc.optional;



import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class step2 {


    public static void main(String[] args) {
        Optional<String> opt = Optional.of("Baeldung");
        val x =new ArrayList<>();
        List<String> test = data();
        Optional<List<String>> v =Optional.ofNullable(test);
        System.out.println("v.isPresent() = " + v.isPresent());



    }
    public  static Optional<List<String>> data1(){

        return null;
    }

    public  static List<String> data(){
        List<String> n = Arrays.asList("thuc","thanh");
        return n;
    }
}
