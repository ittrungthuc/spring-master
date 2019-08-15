package com.trungthuc.lambda;

public class test {
    public static void main(String[] args) {

   
        for (int i=10 ;i<100;i++){
            int value1 = Integer.parseInt(String.valueOf(i).charAt(0)+"");
            int value2 = Integer.parseInt(String.valueOf(i).charAt(1)+"");
            if (i%(value1+value2)==0){
                System.out.println("value:"+i);
            }


        }

    }
}
