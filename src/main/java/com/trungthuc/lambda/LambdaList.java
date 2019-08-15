package com.trungthuc.lambda;

import java.util.ArrayList;

public class LambdaList {
    public static void main(String[] args) {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
        arrL.forEach( n ->
                {if (n%2==0) System.out.println("n = " + n);}
                );

        Mylambda function =() -> {
            System.out.println(" Mylambda ");
        };

        Sum functionSum=(int x,int y)-> x+y ;

    }

}
interface  Mylambda{
    void foo();
}
interface  Sum{
    int foo(int a, int b);
}