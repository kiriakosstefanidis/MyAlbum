package com.example.Albumproject.album;

import com.example.Albumproject.album.Album;
import com.example.Albumproject.album.CreateAlbum;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "NewAlbumServlet" ,value = {"/NewAlbum"})
public class NewAlbumServlet extends HttpServlet {

    private static final long serealversionid = 1L ;
    private CreateAlbum newalbum;
    public void init() {
        newalbum = new CreateAlbum();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/NewAlbum.jsp").forward(request,response);

       // response.getWriter().append("Served at: ").append(request.getContextPath());

        //RequestDispatcher dispatcher = request.getRequestDispatcher("/NewAlbum.jsp");
        //dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String albumID = request.getParameter("AlbumID");
    String albumTitle = request.getParameter("AlbumTitle");

    Album album = new Album();
    album.setAlbumID(Integer.valueOf(albumID));
    album.setAlbumTitle(albumTitle);

        try {
            CreateAlbum.newalbum(album);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }



        //RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        //dispatcher.forward(request,response);


      response.sendRedirect("/index.jsp");

    }
}
