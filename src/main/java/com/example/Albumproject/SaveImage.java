package com.example.Albumproject;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class SaveImage {
    public static void main(String[] args) throws Exception
    {

        int pos=1;

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp2021", "root", "root");

        File file=new File("C:\\Users\\stifler\\Desktop\\μεθοδολογία\\dbimage.png");
        FileOutputStream fos=new FileOutputStream(file);
        byte b[];
        Blob longblob;

        PreparedStatement stmt=conn.prepareStatement("select * from photos");
        ResultSet rs=stmt.executeQuery();

        while(rs.next()){
            longblob=rs.getBlob("file");
            b=longblob.getBytes(pos,(int)longblob.length());
            fos.write(b);
        }

        stmt.close();
        fos.close();
        conn.close();

    }

}
