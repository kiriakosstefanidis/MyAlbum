package com.example.Albumproject;


import java.sql.*;

    public class InsertImage {

        public int  Upload(Image image) throws Exception {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp2021", "root", "root");

            int result = 0;
            int id = 1;

            //PreparedStatement stmt = conn.prepareStatement("INSERT INTO images VALUES(?,?,?,?,?,?,?)");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO images(imageID,title,tags,latitude,longtitude,date,imagepath)"+" VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1,id);
            stmt.setString(2,image.getTitle());
            stmt.setString(3, image.getTags());
            stmt.setFloat(4,image.getLatitude());
            stmt.setFloat(5,image.getLongtitude());
            stmt.setString(6, String.valueOf(image.getDate()));
            stmt.setString(7, image.getImagepath());

            result = stmt.executeUpdate();
            return result;

        }
    }


