package com.company;

import java.util.ArrayList;

public class Statistics {
    static StoresRepo repoStore = new StoresRepo("jdbc:sqlite:C:/SQLite/Mall.db");
    static StatisticsRepo repoStat = new StatisticsRepo("jdbc:sqlite:C:/SQLite/Mall.db");

    public static void statisticByFloor(int floor) {
        int numberOfOpenLate = 0;
        int numberOfRestaurants = 0;
        int numberOfLargeStores = 0;


        ArrayList<StoresPOJO> storesByFloor = repoStore.select(String.format("SELECT * FROM STORES WHERE FLOOR = %d", floor) );

        for (StoresPOJO one_row : storesByFloor){
            if (one_row.IsOpenLate != 0){
                numberOfOpenLate++;
            }
        }

        for (StoresPOJO one_row : storesByFloor){
            if (one_row.IsRestaurant != 0){
                numberOfRestaurants++;
            }
        }

        for (StoresPOJO one_row : storesByFloor){
            if (one_row.IsLarge != 0){
                numberOfLargeStores++;
            }
        }

        repoStat.update(String.format("UPDATE STATISTICS SET NumberOfOpenLate = %d WHERE FLOOR = %d",
                numberOfOpenLate , floor));
        repoStat.update(String.format("UPDATE STATISTICS SET NumberOfRestaurants = %d WHERE FLOOR = %d",
                numberOfRestaurants , floor));
        repoStat.update(String.format("UPDATE STATISTICS SET NumberOfLargeStores = %d WHERE FLOOR = %d",
                numberOfLargeStores , floor));
        storesByFloor.clear();
    }
}