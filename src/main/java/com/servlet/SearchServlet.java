package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/search", name="searchHandler")
public class SearchServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {
        System.out.println("HANDLING");
    // set content-type header before accessing the Writer
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

    // then write the response
        out.println("<html>" +
                    "<head><title>Search Results</title>" + 
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\" />" + 
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"/stylesheets/main.css\" /></head>" +
                    "<h1>Search Results</h1>" + 
                    "<body>");

        //Get the identifier of the item
        //String firstName = request.getParameter("FirstName");
        //if (firstName != null) {
            //out.println(firstName);
        //}
        out.println("</body></html>");
        out.flush();
        out.close();
    }
}