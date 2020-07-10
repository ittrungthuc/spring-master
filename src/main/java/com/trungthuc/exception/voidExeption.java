package com.trungthuc.exception;

import java.util.Arrays;
import java.util.List;

public class voidExeption {

    public static void main(String[] args) throws Exception {
        accessManager(Arrays.asList("JAVA","JS"),"JS");
    }

    public static void accessManager( List<String> roles, String userOfrole) throws Exception {

        for (String match : roles){
            if ( match.equals(userOfrole) ){
                return;
            }
        }
        throw  new Exception("void ex");

    }
}
