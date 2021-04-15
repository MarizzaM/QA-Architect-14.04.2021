package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Set;

public class UniqueListRepo {

    private String m_conn;

    public UniqueListRepo(String m_conn) {
        this.m_conn = m_conn;
    }

    public ArrayList<UniqueListPOJO> select(String query){

        ArrayList<UniqueListPOJO> numbers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    UniqueListPOJO e = new UniqueListPOJO(
                            rs.getInt("list_numbers"));
                    numbers.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  numbers;
    }
}
