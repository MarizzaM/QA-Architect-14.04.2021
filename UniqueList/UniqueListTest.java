package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class UniqueListTest {

    UniqueListRepo repo = new UniqueListRepo("jdbc:sqlite:C:/SQLite/UniqueListTest.db");

    @Test
    public void addPosNumber(){
        ArrayList<UniqueListPOJO> methodData = repo.select("Select * from numbersForTest where list_numbers > 0");

        UniqueList uniqueList = new UniqueList();

        for (UniqueListPOJO one_row : methodData) {
            boolean actual_result =  uniqueList.add(one_row.list_numbers);
            assertEquals(true, actual_result);
        }
    }

    @Test
    public void addNegNumber(){
        ArrayList<UniqueListPOJO> methodData = repo.select("Select * from numbersForTest where list_numbers < 0");

        UniqueList uniqueList = new UniqueList();

        for (UniqueListPOJO one_row : methodData) {
            boolean actual_result =  uniqueList.add(one_row.list_numbers);
            assertEquals(false, actual_result);
        }
    }

    @Test (expected = ArithmeticException.class)
    public void addZeroNumber(){
        ArrayList<UniqueListPOJO> methodData = repo.select("Select * from numbersForTest where list_numbers = 0");

        UniqueList uniqueList = new UniqueList();

        for (UniqueListPOJO one_row : methodData) {
            boolean actual_result =  uniqueList.add(one_row.list_numbers);
            assertEquals(true, actual_result);
        }
    }

    @Test
    public void addSameNumbers(){

        UniqueList uniqueList = new UniqueList();
        uniqueList.list_numbers.add(5);
        uniqueList.list_numbers.add(5);

        assertEquals(1, uniqueList.list_numbers.size());
    }
}
