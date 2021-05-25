package com.example.Albumproject;

import com.mysql.cj.jdbc.Blob;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(name = "InsertPageServlet", urlPatterns = {"/InsertPage"})
@MultipartConfig
public class InsertPageServlet extends HttpServlet {

    public InsertImage insertImage = new InsertImage();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>");
            out.print("\n" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<style>\n" +
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
                    "        }" +
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
                    "    </style>" +
                    "<body>\n" +
                    "<body>\n" +
                    "\n" +
                    "<div class=\"header\">\n" +
                    "    <h1>My Photo Album 2021</h1>\n" +
                    "    <p>The ultimate web site for your photos.</p>\n" +
                    "</div>\n" +
                    "\n" +
                    "<div class=\"menubar\">\n" +
                    "    <a href=\"/\">ΑΡΧΙΚΗ</a>\n" +
                    "    <a href=\"/InsertPage\">ΠΡΟΣΘΗΚΗ</a>\n" +
                    "    <a href=\"/DisplayPage\">ΠΡΟΒΟΛΗ</a>\n" +
                    "\n" +
                    "</div>" +
                    "<h1 style=\"text-align:center\">Πρόσθεσε την φωτογραφία σου!</h1>\n" +
                    "\n" +
                    "<div>\n" +
                    "  <form action=\"/InsertPage\" method=\"POST\" enctype=\"multipart/form-data\">\n" +
                    "    <label>Θεματική ενότητα</label>\n" +
                    "    <input type=\"text\" name=\"title\">\n" +
                    "    <br>\n" +
                    "    </br>\n" +
                    "    <label>Συμμετέχοντες</label>\n" +
                    "    <input type=\"text\"  name=\"tags\">\n" +
                    "    <br>\n" +
                    "    </br>\n" +
                    "    <label>Ημερομηνία</label>\n" +
                    "    <input type=\"datetime\"  name=\"date\">\n" +
                    "    <br>\n" +
                    "    </br>\n" +
                    "    <label>Γεωγραφικό μίκος</label>\n" +
                    "    <input type=\"float\" name=\"longtitude\">\n" +
                    "    <br>\n" +
                    "    </br>\n" +
                    "    <label>Γεωγραφικό πλάτος</label>\n" +
                    "    <input type=\"float\" name=\"latitude\">\n" +
                    "    <br>\n" +
                    "    </br>\n" +
                    "\n" +
                    "    <label>Επιλογή Αρχείου:</label>\n" +
                    "    <input type=\"file\" id=\"myfile\" name=\"imagepath\" multiple>\n" +
                    "    <br>\n" +
                    "    </br>\n" +
                    "\n" +
                    "    <input type=\"submit\" value=\"Προσθήκη\">\n" +
                    "\n" +
                    "  </form>\n" +
                    "</div>\n" +
                    "<div class=\"footer\">\n" +
                    "    <p>We are three undergraduate students in International Hellenic University and this is the semester project for the programming methodology</p>\n" +
                    "</div>" +
                    "</body>\n" +
                    "</html>");

        } finally {
            out.close();
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request,response);
        //getServletContext().getRequestDispatcher("/insertimage.html").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String tags = request.getParameter("tags");
        String latitude = request.getParameter("latitude");
        String longtitude = request.getParameter("longtitude");
        String date = request.getParameter("date");
        String imagepath = request.getParameter("imagepath");



        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Image image = new Image();
        image.setTitle(title);
        image.setTags(tags);
        image.setLatitude(Float.valueOf(latitude));
        image.setLongtitude(Float.valueOf(longtitude));

        try {
            image.setDate(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Part filePart = request.getPart("imagepath");

            if (filePart.getSubmittedFileName().endsWith(".jpg") || filePart.getSubmittedFileName().endsWith(".png")) {

                InputStream fileInputStream = filePart.getInputStream();
                File fileToSave = new File("C:/Users/georg/Downloads/apache-tomcat-9.0.46/webapps/ROOT/" + filePart.getSubmittedFileName());
                Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            image.setImagepath(filePart.getSubmittedFileName());

            try {
                insertImage.Upload(image);
            } catch (Exception e) {
                e.printStackTrace();
            }

        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request,response);

    }
}
