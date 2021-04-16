package com.company;

import org.junit.Test;

import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;

public class BuildingTest {

    BuildingRepo repo = new BuildingRepo("jdbc:sqlite:C:/SQLite/BuildingTestData.db");

    @Test
    public void collectMoneyTest(){
        ArrayList<BuildingPOJO> methodData = repo.select("Select * from Building where test_name = 'TestA'");
        Building building = new Building();

        for (BuildingPOJO one_row : methodData) {
            float actual_result =  building.collectMoney(one_row.number_of_residents);
            assertEquals(one_row.cashbox, actual_result);
        }

    }

    @Test
    public void maintainBuildingTest_notEnoughMoneyInCashBoxForService(){
        ArrayList<BuildingPOJO> methodData = repo.select("Select * from Building where test_name = 'TestB'");
        Building building = new Building();

        for (BuildingPOJO one_row : methodData) {

            building.cashbox = one_row.cashbox;
            building.is_building_clean = one_row.is_building_clean;
            building.is_electricity_working = one_row.is_electricity_working;
            boolean actual_result =  building.maintainBuilding();
            assertEquals(false, actual_result);
        }
    }

    @Test
    public void maintainBuildingTest_Cleaning(){
        ArrayList<BuildingPOJO> methodData = repo.select("Select * from Building where test_name = 'TestC'");
        Building building = new Building();

        for (BuildingPOJO one_row : methodData) {

            building.cashbox = one_row.cashbox;
            building.is_building_clean = one_row.is_building_clean;
            building.is_electricity_working = one_row.is_electricity_working;
            building.maintainBuilding();
            float actual_result =  one_row.cashbox-100;
            assertEquals(building.cashbox, actual_result);
        }
    }

    @Test
    public void maintainBuildingTest_Electrical(){
        ArrayList<BuildingPOJO> methodData = repo.select("Select * from Building where test_name = 'TestD'");
        Building building = new Building();

        for (BuildingPOJO one_row : methodData) {

            building.cashbox = one_row.cashbox;
            building.is_building_clean = one_row.is_building_clean;
            building.is_electricity_working = one_row.is_electricity_working;
            building.maintainBuilding();
            float actual_result =  one_row.cashbox-300;
            assertEquals(building.cashbox, actual_result);
        }
    }
}
