package com.example.Albumproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteImage {
    public static void main(String[] args) throws Exception
    {

        int number=1;


        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp2021", "root", "root");

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM photos WHERE photoID = ?;");
        stmt.setInt(1, number);
        stmt.executeUpdate();

    }

}
