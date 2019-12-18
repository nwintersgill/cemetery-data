
//based on http://www.eg.bucknell.edu/~mead/Java-tutorial/servlets/client-interaction/http-methods.html

package com.servlet;

import java.io.IOException;
import java.io.File;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

@WebServlet(urlPatterns="/map", name="mapHandler")
public class MapServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {

        ServletContext context = getServletContext();
        String path = context.getRealPath(File.separator);
        System.out.println("PATH = " + path);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/index.html");

        dispatcher.forward(request, response);


    }


}