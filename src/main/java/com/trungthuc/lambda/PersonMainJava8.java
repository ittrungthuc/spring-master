package com.trungthuc.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonMainJava8 {
    public static void main(String[] args) {
        List<Person> list= Arrays.asList(

                new Person("thuc","nguyen","1996-01-17",2),
                new Person("phu","tran","1996-01-17",5),
                new Person("phuoc","thanh","1996-01-17",6),
                new Person("Pho","vo","1996-01-17",1),
                new Person("Phi","php","1996-01-17",44),
                new Person("nhan","duc","1996-01-17",7)
        );

        Collections.sort(list, (Person p1,Person p2) -> p1.getAge() > p2.getAge() ? 1 : -1);

        System.out.println("listLambda = " + list);
        prinfList(list, p -> p.getFirstName().startsWith("t"));
    }
    private  static void prinfList(List<Person> people,printfIF printfIF){
        people.forEach(p -> System.out.println("p = " + p));
    }
}
