package com.company;

public class StatisticsPOJO {

    public int Id;
    public int Floor;
    public int NumberOfRestaurants;
    public int NumberOfOpenLate;
    public int NumberOfLargeStores;

    public StatisticsPOJO() {
    }

    public StatisticsPOJO(int id, int floor, int numberOfRestaurants, int numberOfOpenLate, int numberOfLargeStores) {
        Id = id;
        Floor = floor;
        NumberOfRestaurants = numberOfRestaurants;
        NumberOfOpenLate = numberOfOpenLate;
        NumberOfLargeStores = numberOfLargeStores;
    }

    @Override
    public String toString() {
        return "StatisticsPOJO{" +
                "Id=" + Id +
                ", Floor=" + Floor +
                ", NumberOfRestaurants=" + NumberOfRestaurants +
                ", NumberOfOpenLate=" + NumberOfOpenLate +
                ", NumberOfLargeStores=" + NumberOfLargeStores +
                '}';
    }


}
