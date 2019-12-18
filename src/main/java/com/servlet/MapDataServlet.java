
//based on http://www.eg.bucknell.edu/~mead/Java-tutorial/servlets/client-interaction/http-methods.html

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.util.ArrayList;

import com.data.Plot;
import com.data.Search;

@WebServlet(urlPatterns="/mapdata", name="mapDataHandler")
public class MapDataServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/plain");
        PrintWriter result = response.getWriter();

        ArrayList<Plot> plotList = Search.SearchDB(new Plot());

        for (Plot p : plotList) {
            result.println(p.getFirstName() + "," + p.getMiddleName() + "," + p.getLastName() + "," + p.getBirthYear() + "," + p.getDeathYear() + "," + p.getLocation() + "," + p.getNotes());
        }

        result.flush();
        result.close();
    }


}