package com.trungthuc.arrays;

import java.util.Arrays;

public class SortArrays {
    public static void main(String[] args) {
        int [] arrss = new int[]{ 1,44,3,4,1,2,7,22,9,10 };
        sortASC(arrss);
        for (int i = 0; i < arrss.length; i++) {
            System.out.print(arrss[i] + " ");
        }

    }
    public  static void sortASC(int [] arrs){
        int next = arrs[0];
        for (int i = 0 ; i < arrs.length - 1 ; i ++  ){
            for (int j = i + 1 ; j < arrs.length ; j++ ){
                    if ( arrs[i] > arrs[j] ){
                        next = arrs[j];
                        arrs[j] = arrs[i];
                        arrs[i] = next;
                    }
            }
        }
    }
}
