package com.trungthuc.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {
        List<String> strings= Arrays.asList("i","love","you","!");

        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
      //  numbers.stream().skip(2).limit(4).forEach(System.out::println);

      //  int percent = (int) numbers.stream().filter(number -> number %2==0).count();
       // System.out.println("percent = " + percent);

        List<String> filter =strings.stream().filter(text ->
                !text.isEmpty() && text !=null).collect(Collectors.toList());

        strings.stream().map(String::trim).forEach(System.out::println);

        Stream.iterate(1, count -> count + 1) //
                .filter(number -> number % 3 == 0) //
                .limit(6) //
                .forEach(System.out::println);

        Integer sum =numbers.stream().reduce(0,Integer::sum);
        System.out.println("sum = " + sum);
        
        String con =strings.stream().reduce("",String::concat);
        System.out.println("con = " + con);
    }

}
