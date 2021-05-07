package com.example.Albumproject.album;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteAlbum {
    public static void main(String[] args) throws Exception
    {

        int ID=1;


        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp2021", "root", "root");

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM albums WHERE albumID = ?;");
        stmt.setInt(1, ID);
        stmt.executeUpdate();

    }
}
