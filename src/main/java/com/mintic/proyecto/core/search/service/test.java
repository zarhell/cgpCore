package com.mintic.proyecto.core.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class test {
    //The list of first 20 terms in the Fibonacci Sequence is:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181.


 
    public static void main(String[] args) {
        
    
    Integer input1 = 2;
    Integer input2 = 3;
    Integer end = 20;

    List<Integer> list = new ArrayList<Integer>();
   
    if(list.isEmpty()){
       
        list.add(0);
    }

    IntStream.range(0, end).forEach(
        idx -> extracted(input1, input2));

    }

    private static void extracted(Integer input1, Integer input2) {
        System.out.println(input1);
        Integer value = input1+input2;
        input1 = input2;
        input2 = value;
    }



}
