package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StatisticsRepo {

    private final String m_conn;

    public StatisticsRepo(String m_conn) {
        this.m_conn = m_conn;
    }

    ArrayList<StatisticsPOJO> results = new ArrayList<>();

    public ArrayList<StatisticsPOJO> select (String query){
        try (Connection conn = DriverManager.getConnection(m_conn)){

            if (conn != null){
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()){
                    StatisticsPOJO row_data = new StatisticsPOJO(
                            rs.getInt("Id"),
                            rs.getInt("Floor"),
                            rs.getInt("NumberOfRestaurants"),
                            rs.getInt("NumberOfOpenLate"),
                            rs.getInt("NumberOfLargeStores")
                    );
                    results.add(row_data);
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return results;
    }

    public StatisticsPOJO getById(int id){
        results = select("SELECT * FROM STATISTICS WHERE ID = " + id);

        if (results.size() == 0)
            return null;

        return results.get(0);
    }

    public void update(String query){
        try (Connection conn = DriverManager.getConnection(m_conn)){

            if (conn != null){
                Statement stmt = conn.createStatement();
                int rows = stmt.executeUpdate(query);
                System.out.println(String.format("%d rows update", rows));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
