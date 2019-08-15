package com.trungthuc.lambda.ExConsumer;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class HandingExeption {

    public static void main(String[] args) {
        int [] year={424,42343,432,432,4,5,43,656,7,4,324};
        int key =1996;
//        exec(year,key,(v,k) ->
//         System.out.println("key = " + (v+k))
//       );


        int a=7;
        int b=0;

        exec(a,b,(k,v)-> System.out.println("(k+v) = " + (k+v)));
        exec(a,b,(k,v)-> System.out.println("(k-v) = " + (k-v)));
        exec(a,b,(k,v)-> System.out.println("(k/v) = " + (k/v)));
        exec(a,b,(k,v)-> System.out.println("(k*v) = " + (k*v)));

    }
    public static void exec(int [] arr, int kt, BiConsumer<Integer,Integer> biConsumer){
      for(int i : arr){
          biConsumer.accept(i,kt);
      }
    }

    public static void exec(int a, int b, BiConsumer<Integer,Integer> biConsumer){
        try {
            biConsumer.accept(a,b);
            System.out.println("oke");
        }catch (Exception e){
            System.out.println("e.getStackTrace() = " + e.getStackTrace());
        }
            
    }

}
