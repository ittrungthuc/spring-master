package com.trungthuc.currency;

import java.math.BigDecimal;

public class Big {
    public static void main(String[] args) {
        double poit =1.5;
        double donate =1.9;
       // System.out.println("(donate - poit) = " + (donate - poit));
        BigDecimal bp1 =new BigDecimal(poit);
        BigDecimal bp2 =new BigDecimal(donate);

        BigDecimal bp1ST =new BigDecimal(String.valueOf(poit));
        BigDecimal bp2ST =new BigDecimal(String.valueOf(donate));


        System.out.println("bp1.subtract(bp2) = " + bp1.subtract(bp2));
        System.out.println("bDST.subtract(bp2) = " + bp1ST.subtract(bp2ST));
    }
}
