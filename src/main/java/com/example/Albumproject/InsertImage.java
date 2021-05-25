package com.example.Albumproject;


import java.sql.*;

    public class InsertImage {

        public int  Upload(Image image) throws Exception {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp2021", "root", "root");

            int result = 0;


            //PreparedStatement stmt = conn.prepareStatement("INSERT INTO images VALUES(?,?,?,?,?,?,?)");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO images(title,tags,latitude,longtitude,date,imagepath)"+" VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,image.getTitle());
            stmt.setString(2, image.getTags());
            stmt.setFloat(3,image.getLatitude());
            stmt.setFloat(4,image.getLongtitude());
            stmt.setString(5, String.valueOf(image.getDate()));
            stmt.setString(6, image.getImagepath());

            result = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int id = 0 ;
            if (rs.next()) {
                // Value of ID (Index 1 by table design).
                id = rs.getInt(1);
            }
            return result;

        }
    }


