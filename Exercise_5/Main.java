package com.company;

public class Main {

    static StoresRepo repoStore = new StoresRepo("jdbc:sqlite:C:/SQLite/Mall.db");

    public static void main(String[] args) {
        repoStore.Update("UPDATE Stores SET Floor = 1 WHERE Name LIKE 'Japanika'");
    }

}
