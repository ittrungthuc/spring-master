package com.trungthuc.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainCar {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("BMW",2019,"2l"),
                new Car("MER",2014,"2l"),
                new Car("HONDA",2000,"2l"),
                new Car("EX",2013,"2l"),
                new Car("JEEP",2016,"2l"),
                new Car("PLK",2011,"2l"),
                new Car("AWS",2010,"2l"),
                new Car("NMJ",2009,"2l")

        );
        System.out.println("test1(c) = " + test3(cars));

//        Optional<String> getHonda = Optional.ofNullable(
//                cars.stream().filter(car -> car.getName().equals("HONDAz") )
//                .map(Car::getName)
//                .findAny()
//                .orElse(null));
//
//        System.out.println("getHonda.get() = " + getHonda.isPresent());
//        System.out.println(" list a: ");
//        cars.stream().forEach(car -> System.out.println("car.getName() = " + car.getYear()));
//
//
//        Collections.sort(cars, (Car carA,Car carB) -> carA.getYear() > carB.getYear() ? 1 :-1);
//        System.out.println(" list b: ");
//        cars.stream().forEach(car -> System.out.println("car.getName() = " + car.getYear()));

//        AtomicReference<String> text = new AtomicReference<>("init");
//
//        List<Car> lamda = cars.stream().filter(car ->
//                    {
//                        if(car.getYear() >2015 && !car.getName().isEmpty()){
//                            text.set("trung thuc");
//                            return  true;
//                        }
//                        return false;
//                    }).collect(Collectors.toList());
//
//
//        System.out.println("text = " + text.get());
//        System.out.println(text.get() instanceof String);
    }
    static long test1(List<Car> users){
        long time1 = System.currentTimeMillis();
        users.stream()
                .filter((u) -> u.getName() == "BMW" && u.getYear() % 2 == 0)
                .allMatch(u -> true);                   //  test lambda1
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }

    static long test2(List<Car> users){
        long time1 = System.currentTimeMillis();
        users.stream()
                .filter(u -> u.getName() == "BMW")
                .filter(u -> u.getYear() % 2 == 0)
                .filter(Car :: isUse)
                .allMatch(u -> true);                   // test lamba 2
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
    static long test3(List<Car> users){
        long time1 = System.currentTimeMillis();
        users.stream()
                .filter(((Predicate<Car>) u -> u.getName() == "BMW").and(u -> u.getYear() % 2 == 0))
                .allMatch(u -> true);                   // test lamda3
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
    
}
