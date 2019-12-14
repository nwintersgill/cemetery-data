package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


public class BookDetailServlet extends HttpServlet {

    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {
    // set content-type header before accessing the Writer
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

    // then write the response
        out.println("<html>" +
                    "<head><title>Book Description</title></head>");

        //Get the identifier of the item
        String firstName = request.getParameter("FirstName");
        if (firstName != null) {
            // and the information about the item and print it
        }
        out.println("</body></html>");
        out.close();
    }
}