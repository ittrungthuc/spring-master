package com.trungthuc.lambda;

import java.util.*;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> list= Arrays.asList(
          new Person("thuc","nguyen","1996-01-17",2),
          new Person("phu","tran","1996-01-17",5),
          new Person("phuoc","thanh","1996-01-17",6),
          new Person("Pho","vo","1996-01-17",1),
          new Person("Phi","php","1996-01-17",44),
          new Person("nhan","duc","1996-01-17",7)
        );

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
       prinfList(list, new printfIF() {
           @Override
           public boolean Concat(Person person) {
               return person.getFirstName().startsWith("t");
           }
       });
    }
    private  static void prinfList(List<Person> people,printfIF printfIF){
        for (Person p :people){
            System.out.println("p = " + p);
        }
    }
}


interface  printfIF{
    boolean Concat(Person person);
}
