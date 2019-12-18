
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
import com.data.Sort;

/* TODO get thymleaf working so we can use fragments
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateMode;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
*/

@WebServlet(urlPatterns="/search", name="searchHandler")
public class SearchServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {
    // set content-type header before accessing the Writer
        response.setContentType("text/html");
        PrintWriter result = response.getWriter();

    //Get the identifiers of the items
        String firstName = request.getParameter("FirstName");
        String middleName = request.getParameter("MiddleName");
        String lastName = request.getParameter("LastName");
        String born = request.getParameter("YearBorn");
        String died = request.getParameter("YearDied");

    // then write the response
        result.println(
                    /*"<!DOCTYPE html>" + 
                    "<html xmlns:th=\"http://www.thymeleaf.org\" th:replace=\"~{fragments/layresult :: layresult (~{::body},'search')}\">" +
                    "<head>" + 
                    "<title>Search Results</title>" + 
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\" />" + 
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"/stylesheets/main.css\" />" + 
                    "</head>" + 
                    */

                    //layout.html (thymeleaf isn't working with the servlet for now)
                    "<!DOCTYPE html>" + 
"<html>" + 
"<head>" + 
"    <title>Cemetery Data</title>" + 
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\" />" + 
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"/stylesheets/main.css\" />" + 
"</head>" + 
"" + 
"<body>" + 
"    <nav class=\"navbar navbar-default navbar-static-top navbar-inverse\">" + 
"        <div class=\"container\">" + 
"            <ul class=\"nav navbar-nav\">" + 
"                <li>" + 
"                    <a href=\"/\"><span class=\"glyphicon glyphicon-home\"></span> Home</a>" + 
"                </li>" + 
"                <li class=\"active\">" + 
"                    <div class=\"popup\" onclick=\"toggleSearchPopup()\"> Search </div>" + 
"                    <form class=\"popuptext\" id=\"searchPopup\" method=\"get\" action=\"search\">" + 
"                        " + 
"                            <label>First Name:</label> <input type=\"text\" name=\"FirstName\" value=\"" + firstName + "\"><br>" + 
"                        " + 
"                            <label>Middle Name:</label> <input type=\"text\" name=\"MiddleName\" value=\"" + middleName + "\"><br>" + 
"                        " + 
"                            <label>Last Name:</label> <input type=\"text\" name=\"LastName\" value=\"" + lastName + "\"><br>" + 
"" + 
"                            <!-- Spouse" + 
"                            <label>Spouse:</label> <input type=\"text\" name=\"Spouse\"><br>" + 
"                            -->" + 
"" + 
"                            <label>Year Born:</label> <input type=\"text\" name=\"YearBorn\" value=\"" + born + "\"><br>" + 
"" + 
"                            <label>Year Died:</label> <input type=\"text\" name=\"YearDied\" value=\"" + died + "\"><br>" + 
"" + 
"                        <input type=\"submit\" value=\"Search\">" + 
"                    </form>" + 
"                </li>" +  
"            </ul>" + 
"            <ul class=\"nav navbar-nav navbar-right\">" + 
"                <li class=\"navbar-right\">" + 
"                    <a href=\"url\"><span class=\"glyphicon glyphicon-book\"></span> About Us</a>" + 
"                </li>" + 
"            </ul>" + 
"        </div>" + 
"    </nav>" + 
"    <div th:replace=\"${template}\"/>" + 
"" + 
"    <script th:src=\"@{/webjars/jquery/jquery.min.js}\"></script>" + 
"    <script th:src=\"@{/webjars/jquery-ui/jquery-ui.min.js}\"></script>" + 
"    <script th:src=\"@{/webjars/bootstrap/js/bootstrap.min.js}\"></script>");



 
        result.println(
                        "<div class=\"container\">" +
                        "<div class=\"dropdown\">" + 
"                           <label> Sort by </label>" + 
"                           <select name=\"sortMethod\" form=\"searchPopup\">" + 
"                               <option value=\"first\">First Name</option>" + 
"                               <option value=\"last\" selected>Last Name</option>" + 
"                               <option value=\"birth\">Birth Year</option>" + 
"                               <option value=\"death\">Death Year</option>" + 
"                           </select>" + 
"                           <input type=\"submit\" value=\"Sort\" form=\"searchPopup\">" + 
"                       </div>" + 
                        "<h1>Search Results</h1>" + 
                        "<hr>");

        Plot searchTerms = new Plot();
        searchTerms.setFirstName(firstName);
        searchTerms.setMiddleName(middleName);
        searchTerms.setLastName(lastName);
        try {
            searchTerms.setBirthYear(Integer.parseInt(born));
        } catch (NumberFormatException e) {
            searchTerms.setBirthYear(-1);
        }
        try {
            searchTerms.setDeathYear(Integer.parseInt(died));
        } catch(NumberFormatException e) {
            searchTerms.setDeathYear(-1);
        }

        ArrayList<Plot> plotList;
        plotList = Search.SearchDB(searchTerms);
        //plotList = new ArrayList<>();
        //plotList.add(searchTerms);


        if (plotList.isEmpty()) {
            result.println("No search results.");
        } else {
            result.println("<ul>");
            for (Plot p : plotList) {
                result.println("<li>");
                printSearchResult(result, p);
                result.println("</li>");
            }
            result.println("</ul>");
        }


        result.println("</div>");


        result.println("</body>");
        result.println("<script>" + 
"    function toggleSearchPopup() {" + 
"        let popup = document.getElementById(\"searchPopup\");" + 
"        popup.classList.toggle(\"show\");" + 
"    }" + 
"</script>");
        result.println("</html>");
        result.flush();
        result.close();
    }

    private void printSearchResult(PrintWriter out, Plot plot) {
        String firstName = plot.getFirstName();
        String middleName = plot.getMiddleName();
        String lastName = plot.getLastName();
        String born = Integer.toString(plot.getBirthYear());
        String died = Integer.toString(plot.getDeathYear());
        String location = plot.getLocation();
        String notes = plot.getNotes();

        if (Search.isValid(firstName)) {
            out.println(firstName + " ");
        }
        if (Search.isValid(middleName)) {
            out.println(middleName + " ");
        }
        if (Search.isValid(lastName)) {
            if (Search.isValid(born) || Search.isValid(died) || Search.isValid(location)) {
                out.println(lastName + ", ");
            } else {
                out.println(lastName + " ");
            }
        }
        if (Search.isValid(born)) {
            if (Search.isValid(died) || Search.isValid(location)) {
                out.println("Born " + born + ", ");
            } else {
                out.println("Born " + born + " ");
            }
        }
        if (Search.isValid(died)) {
            if (Search.isValid(location)) {
                out.println("Died " + died + ", ");
            } else {
                out.println("Died " + died);
            }
        }
        if (Search.isValid(location)) {
            out.println("Plot " + location);
        }
        if (Search.isValid(notes)) {
            out.println(": " + notes);
        }
    }


}