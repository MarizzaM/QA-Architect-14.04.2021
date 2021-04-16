package com.company;

import java.sql.*;
import java.util.ArrayList;

public class BuildingRepo {

    private String m_conn;

    public BuildingRepo(String m_conn) {
        this.m_conn = m_conn;
    }

    public ArrayList<BuildingPOJO> select(String query) {

        ArrayList<BuildingPOJO> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    BuildingPOJO row_data = new BuildingPOJO(
                            rs.getString("test_name"),
                            rs.getInt("number_of_residents"),
                            rs.getString("is_building_clean"),
                            rs.getString("is_electricity_working"),
                            rs.getFloat("cashbox"),
                            rs.getInt("tariff"));
                    results.add(row_data);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return results;
    }
}
