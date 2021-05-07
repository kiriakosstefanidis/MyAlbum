package com.example.Albumproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;



@WebServlet(name = "InsertPageServlet", urlPatterns = {"/InsertPage"})
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
                    "  input[type=text], select {\n" +
                    "    width: 100%;\n" +
                    "    padding: 12px 20px;\n" +
                    "    margin: 8px 0;\n" +
                    "    display: inline-block;\n" +
                    "    border: 1px solid #ccc;\n" +
                    "    border-radius: 4px;\n" +
                    "    box-sizing: border-box;\n" +
                    "  }\n" +
                    "\n" +
                    "  input[type=submit] {\n" +
                    "    width: 100%;\n" +
                    "    background-color: #4CAF50;\n" +
                    "    color: white;\n" +
                    "    padding: 14px 20px;\n" +
                    "    margin: 8px 0;\n" +
                    "    border: none;\n" +
                    "    border-radius: 4px;\n" +
                    "    cursor: pointer;\n" +
                    "  }\n" +
                    "\n" +
                    "  input[type=submit]:hover {\n" +
                    "    background-color: #333;\n" +
                    "  }\n" +
                    "\n" +
                    "  div {\n" +
                    "    border-radius: 5px;\n" +
                    "    background-color: #f2f2f2;\n" +
                    "    padding: 20px;\n" +
                    "  }\n" +
                    "</style>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h3>Πρόσθεσε την φωτογραφία σου!</h3>\n" +
                    "\n" +
                    "<div>\n" +
                    "  <form action=\"/InsertPage\" method=\"POST\">\n" +
                    "\n" +
                    "    <label>Θεματική ενότητα</label>\n" +
                    "    <input type=\"text\" name=\"title\">\n" +
                    "\n" +
                    "    <label>Συμμετέχοντες</label>\n" +
                    "    <input type=\"text\"  name=\"tags\">\n" +
                    "\n" +
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
                    "    <input type=\"file\" id=\"myfile\" name=\"imagepath\">\n" +
                    "    <br>\n" +
                    "    </br>\n" +
                    "\n" +
                    "    <input type=\"submit\" value=\"Submit form\">\n" +
                    "\n" +
                    "  </form>\n" +
                    "</div>\n" +
                    "\n" +
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
        System.out.println(title);
        String tags = request.getParameter("tags");
        System.out.println(tags);
        String latitude = request.getParameter("latitude");
        System.out.println(latitude);
        String longtitude = request.getParameter("longtitude");
        System.out.println(longtitude);
        String date = request.getParameter("date");
        System.out.println(date);
        String imagepath = request.getParameter("imagepath");
        System.out.println(imagepath);

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
        image.setImagepath(imagepath);

        try {
            insertImage.Upload(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request,response);

    }
}
