
//based on http://www.eg.bucknell.edu/~mead/Java-tutorial/servlets/client-interaction/http-methods.html

package com.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns="/map", name="mapHandler")
public class MapServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");

        dispatcher.forward(request, response);


    }


}