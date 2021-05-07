package com.example.Albumproject.album;


import com.example.Albumproject.album.Album;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateAlbum {

    public static int newalbum(Album album) throws ClassNotFoundException, SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp2021", "root", "root");

       int result = 0;

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO albums VALUES(?,?)");
        stmt.setInt(1,album.getAlbumID());
        stmt.setString(2,album.getAlbumTitle());
        result = stmt.executeUpdate();
        return result;
    }
}
