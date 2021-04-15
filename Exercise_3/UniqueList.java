package com.company;

import java.util.HashSet;
import java.util.Set;

public class UniqueList {

    public Set<Integer> list_numbers = new HashSet<>();

    public UniqueList() {
    }

    public boolean add(int number){
        if (number > 0){
            list_numbers.add(number);
            return true;
        }
        if (number < 0){
            list_numbers.add(number);
            return false;
        }
        else
            throw new ArithmeticException("Number is 0");
    }

    @Override
    public String toString() {
        return "UniqueList{" +
                "list_numbers=" + list_numbers +
                '}';
    }
}
