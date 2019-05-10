package com.tian.mybatis;

import org.junit.Test;

import java.sql.*;

public class DriverTest {

    public DriverTest() {
    }


    @Test
    public void testDriver() throws SQLException {
        String url = "jdbc:mysql://172.16.3.6:3308/cap_control";
        String userName = "cap_control";
        String password = "cap_control_123";
        System.out.println("hello");

        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_info");
        while (resultSet.next()) {
            String user_email = resultSet.getString("user_email");
            System.out.println(user_email);
        }

    }

}
