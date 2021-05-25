package com.example.Albumproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.sql.*;

@WebServlet(name = "DisplayPageServlet", urlPatterns = {"/DisplayPage"})
public class DisplayPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {





        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

            out.print("\n" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <style>\n" +
                    "        * {\n" +
                    "            box-sizing: border-box;\n" +
                    "        }\n" +
                    "\n" +
                    "        body {\n" +
                    "            font-family: Arial;\n" +
                    "            padding: 20px;\n" +
                    "            background: #f1f1f1;\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        .header {\n" +
                    "            padding: 30px;\n" +
                    "            text-align: center;\n" +
                    "            background: white;\n" +
                    "        }\n" +
                    "\n" +
                    "        .header h1 {\n" +
                    "            font-size: 50px;\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        .menubar {\n" +
                    "            overflow: hidden;\n" +
                    "            background-color: #333;\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        .menubar a {\n" +
                    "            float: left;\n" +
                    "            display: block;\n" +
                    "            color: #f2f2f2;\n" +
                    "            text-align: center;\n" +
                    "            padding: 14px 16px;\n" +
                    "            text-decoration: none;\n" +
                    "        }\n" +
                    "        .menubar a:hover{\n" +
                    "            border-radius: 20%;\n" +
                    "            transition: 0.1s ease-in-out;\n" +
                    "            background-color: #666058;\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        /* Create two unequal columns that floats next to each other */\n" +
                    "        /* Left column */\n" +
                    "        .leftcolumn {\n" +
                    "            float: left;\n" +
                    "            width: 75%;\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        /* Album */\n" +
                    "        .album {\n" +
                    "            background-color: #aaa;\n" +
                    "            width: 20%;\n" +
                    "            padding: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        .card {\n" +
                    "            background-color: white;\n" +
                    "            padding: 20px;\n" +
                    "            margin-top: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Clear floats after the columns */\n" +
                    "        .row:after {\n" +
                    "            content: \"\";\n" +
                    "            display: table;\n" +
                    "            clear: both;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Footer */\n" +
                    "        .footer {\n" +
                    "            padding: 20px;\n" +
                    "            text-align: center;\n" +
                    "            background: #ddd;\n" +
                    "            margin-top: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */\n" +
                    "        @media screen and (max-width: 800px) {\n" +
                    "            .leftcolumn, .rightcolumn {\n" +
                    "                width: 100%;\n" +
                    "                padding: 0;\n" +
                    "            }\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */\n" +
                    "        @media screen and (max-width: 400px) {\n" +
                    "            .menubar  a {\n" +
                    "                float: none;\n" +
                    "                width: 100%;\n" +
                    "            }\n" +
                    "        }\n" +
                    "\t\t.column {\n" +
                    "  float: left;\n" +
                    "  width: 15%;\n" +
                    "  padding: 5px;\n" +
                    "}\n" +
                    "\n" +
                    "/* Style the images inside the grid */\n" +
                    ".column img {\n" +
                    "  opacity: 0.8; \n" +
                    "  cursor: pointer; \n" +
                    "}\n" +
                    "\n" +
                    ".column img:hover {\n" +
                    "  opacity: 1;\n" +
                    "transition: 0.5s;\n"+
                    "}\n" +
                    "\n" +
                    "/* Clear floats after the columns */\n" +
                    ".row:after {\n" +
                    "  content: \"\";\n" +
                    "  display: table;\n" +
                    "  clear: both;\n" +
                    "}\n" +
                    "\n" +
                    "/* The expanding image container */\n" +
                    ".container {\n" +
                    "  position: relative;\n" +
                    "  display: none;\n" +
                    "}\n" +
                    "\n" +
                    "/* Expanding image text */\n" +
                    "#imgtext {\n" +
                    "  position: absolute;\n" +
                    "  bottom: 15px;\n" +
                    "  left: 15px;\n" +
                    "  color: white;\n" +
                    "  font-size: 20px;\n" +
                    "}\n" +
                    "\n" +
                    "/* Closable button inside the expanded image */\n" +
                    ".closebtn {\n" +
                    "  position: absolute;\n" +
                    "  top: 10px;\n" +
                    "  right: 15px;\n" +
                    "  color: white;\n" +
                    "  font-size: 35px;\n" +
                    "  cursor: pointer;\n" +
                    "}\n" +
                    "#map {\n" +
                    "        height: 400px;\n" +
                    "        /* The height is 400 pixels */\n" +
                    "        width: 100%;\n" +
                    "        /* The width is the width of the web page */\n" +
                    "      }"+
                    "    </style>\n" +
                    "</head>");
                    out.print("<body>\n" +
                    "\n" +
                    "<div class=\"header\">\n" +
                    "    <h1>My Photo Album 2021</h1>\n" +
                    "    <p>The ultimate web site for your photos.</p>\n" +
                    "</div>\n" +
                    "\n" +
                    "<div class=\"menubar\">\n" +
                    "    <a href=\"/\">ΑΡΧΙΚΗ</a>\n" +
                    "    <a href=\"InsertPage\">ΠΡΟΣΘΗΚΗ</a>\n" +
                    "    <a href=\"DisplayPage\">ΠΡΟΒΟΛΗ</a>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "");
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp2021", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from images");
                out.print("<div class=\"row\">");
                while (rs.next()) {
                    String title = rs.getString("title");
                    String tags = rs.getString("tags");
                    Float latitude = rs.getFloat("latitude");
                    Float longtitude = rs.getFloat("longtitude");
                    String date = rs.getString("date");
                    String imagepath = rs.getString("imagepath");
                    out.print("<div class=\"column\">\n" +
                            "    <img src=\""+imagepath+"\" alt=\"Τίτλος:"+title+" \n Συμμετέχοντες:"+tags+" \n Ημερομηνία:"+date+"\" style=\"width:100%\" onclick=\"myFunction(this); initMap("+longtitude+","+latitude+");\">\n" +
                            "  </div>" );


                    }

                    out.print("\n" +
                            "</div>\n"+
                            "<div class=\"container\">\n" +
                                    "  <span onclick=\"this.parentElement.style.display='none'\" class=\"closebtn\">&times;</span>\n" +
                                    "  <img id=\"expandedImg\" style=\"width:100%\">\n" +
                                    "  <div id=\"imgtext\"></div>\n" +
                            "</div>\n" +
                            "\n" +
                            "<script>\n" +
                            "function myFunction(imgs) {\n" +
                            "  var expandImg = document.getElementById(\"expandedImg\");\n" +
                            "  var imgText = document.getElementById(\"imgtext\");\n" +
                            "  expandImg.src = imgs.src;\n" +
                            "  imgText.innerHTML = imgs.alt;\n" +
                            "  expandImg.parentElement.style.display = \"block\";\n" +
                            "}\n" +
                            "</script>"+
                            "</div>\n" +
                            "<div id=\"map\"></div>"+
                            "<script\n" +
                            "      src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCgxVBaIkbBvQWyruAO8TMWBytArrYG_R8&callback=initMap&libraries=&v=weekly\"\n" +
                            "      async\n" +
                            "    ></script>\n" +
                            "\t    <script>\n" +
                            "      \n" +
                            "      function initMap(p1,p2) {\n" +
                            "        const pic = { lat: p1, lng: p2 };\n" +
                            "        \n" +
                            "        const map = new google.maps.Map(document.getElementById(\"map\"), {\n" +
                            "          zoom: 4,\n" +
                            "          center: pic,\n" +
                            "        });\n" +
                            "        \n" +
                            "        const marker = new google.maps.Marker({\n" +
                            "          position: pic,\n" +
                            "          map: map,\n" +
                            "        });\n" +
                            "      }\n" +
                            "    </script>"+

                    "</div>\n" +
                    "\n");

                    out.print("<div class=\"footer\">\n" +
                    "    <p>We are three undergraduate students in International Hellenic University and this is the semester project for the programming methodology</p>\n" +
                    "</div>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>\n");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
