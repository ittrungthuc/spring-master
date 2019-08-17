package com.trungthuc.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Car {
    private String name;
    private int year;
    private String milon;

    public boolean isUse(){
        return year > new Date().getYear();
    }
}
