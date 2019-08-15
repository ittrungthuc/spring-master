package com.trungthuc.String;

public class ExamString1 {
    public static void main(String[] args) {
        System.out.println("ex1:" + convertManualy("TRUNGTHUC"));
    }
    public  static String convert(String str){
        return String.valueOf(new StringBuilder(str).reverse());
    }
    public  static String convertManualy(String str){
     StringBuilder builder =new StringBuilder();

     for (int i =str.length()-1 ; i >= 0 ; i-- ){
        builder.append(str.charAt(i));
     }
     return builder.toString();
    }
}
