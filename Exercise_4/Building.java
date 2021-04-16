package com.company;

public class Building {


    protected String is_building_clean;
    protected String is_electricity_working;
    protected float cashbox;

    public boolean maintainBuilding(){

        if (is_building_clean.equals("false")){
            callCleaner();
            if (is_building_clean.equals("false")){

                return false;
            }
        }

        if (is_electricity_working.equals("false")){
            callElectrician();
            if (is_electricity_working.equals("false")){

                return false;
            }
        }

        return true;
    }

    public boolean callCleaner(){

        if (cashbox >= 100){
            cashbox -= 100;
            is_building_clean = "true";
            return true;
        } else
            return false;

    }

    public boolean callElectrician(){

        if (cashbox >= 300){
            cashbox -= 300;
            is_electricity_working = "true";
            return true;
        } else
            return false;
    }

    public float collectMoney(int number_of_residents){
        return cashbox += number_of_residents * 80;
    }
}
