package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.company.Statistics.statisticByFloor;

public class StoresRepo {

    private final String m_conn; // connection string

    public StoresRepo(String m_conn) {
        this.m_conn = m_conn;
    }

    ArrayList<StoresPOJO> results = new ArrayList<>();

    public ArrayList<StoresPOJO> select(String query){

        try (Connection conn = DriverManager.getConnection(m_conn)){

            if (conn != null){

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()){
                    StoresPOJO row_data = new StoresPOJO(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getInt("Floor"),
                            rs.getInt("IsRestaurant"),
                            rs.getInt("IsOpenLate"),
                            rs.getInt("IsLarge")
                    );
                    results.add(row_data);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return results;
    }

    public StoresPOJO getById(int id){

        results = select("SELECT * FROM STORES WHERE ID = " + id);

        if (results.size() == 0)
            return null;

        return results.get(0);
    }

    public void Update (String query){
        try (Connection conn = DriverManager.getConnection(m_conn)){

            if (conn != null){

                Statement stmt = conn.createStatement();
                int rows = stmt.executeUpdate(query);

                for (int i = 1; i <= 3; i++)
                    statisticByFloor(i);

                System.out.println(String.format("%d rows updated", rows));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
