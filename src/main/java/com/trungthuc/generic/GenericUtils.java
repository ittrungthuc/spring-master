package com.trungthuc.generic;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class GenericUtils{
    static final int OVERLAY_STREETS  = 1 << 0;
    static final int OVERLAY_ELECTRIC = 1 << 1;
    static final int OVERLAY_PLUMBING = 1 << 2;
    static final int OVERLAY_TERRAIN  = 1 << 3;

    public static void main(String[] args) {
        System.out.println("OVERLAY_STREETS = " + OVERLAY_STREETS);
    }

    static ModelMapper MAP =new ModelMapper();

    public GenericUtils() {
    }

    public static <K,V> V mapto(K key, Class<V> value){
        return MAP.map(key,value);
    }

    public static <K,V> List<V> mapList(List<K> map, Class<V> taget){
          List<V> data = new ArrayList<>();
          for (K k : map){
              taget= (Class<V>) k;
              data.add((V) taget);
          }
        return data;
    }
}
