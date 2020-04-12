package com.trungthuc.arrays;

import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SplitArrays {

   public static Collection<List<Integer>> partitionIntegerListBasedOnSize(List<Integer> inputList, int size) {
        return inputList.stream()
                .collect(Collectors.groupingBy(s -> (s-1)/size))
                .values();
    }
    public static <T> Collection<List<T>> partitionBasedOnSize(List<T> inputList, int size) {
        final AtomicInteger counter = new AtomicInteger(0);
        return inputList.stream()
                .collect(Collectors.groupingBy(s -> counter.getAndIncrement()/size))
                .values();
    }
    public static <T> Collection<List<T>> partitionBasedOnCondition(List<T> inputList, Predicate<T> condition) {
        return inputList.stream().collect(Collectors.partitioningBy(s-> (condition.test(s)))).values();
    }
  // java < 8
    public static  <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        if (chunkSize <= 0) {
            throw new IllegalArgumentException("Invalid chunk size: " + chunkSize);
        }
        List<List<T>> chunkList = new ArrayList<>(list.size() / chunkSize);
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunkList.add(list.subList(i, i + chunkSize >= list.size() ? list.size()-1 : i + chunkSize));
        }
        return chunkList;
    }

    public static void main(String[] args) {

        List<String> data = Arrays.asList("JAVA","JS","PYTHON","NODEJS","PHP","GO","FB","C","NET");

        System.out.printf("SPLIT:" + partitionBasedOnSize(data,7));

    }
}
