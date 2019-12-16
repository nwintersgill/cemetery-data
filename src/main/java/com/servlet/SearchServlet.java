
//based on http://www.eg.bucknell.edu/~mead/Java-tutorial/servlets/client-interaction/http-methods.html

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

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
"                            <label>First Name:</label> <input type=\"text\" name=\"FirstName\"><br>" + 
"                        " + 
"                            <label>Middle Name:</label> <input type=\"text\" name=\"MiddleName\"><br>" + 
"                        " + 
"                            <label>Last Name:</label> <input type=\"text\" name=\"LastName\"><br>" + 
"" + 
"                            <!-- Spouse" + 
"                            <label>Spouse:</label> <input type=\"text\" name=\"LastName\"><br>" + 
"                            -->" + 
"" + 
"                            <label>Year Born:</label> <input type=\"text\" name=\"LastName\"><br>" + 
"" + 
"                            <label>Year Died:</label> <input type=\"text\" name=\"LastName\"><br>" + 
"" + 
"                        <input type=\"submit\" value=\"Search\">" + 
"                    </form>" + 
"                </li>" + 
"                <li>" + 
"                    <a href=\"search\"> Input Data</a>" + 
"                </li>" + 
"            </ul>" + 
"            <ul class=\"nav navbar-nav navbar-right\">" + 
"                <li class=\"navbar-right\">" + 
"                    <a href=\"https://devcenter.heroku.com\"><span class=\"glyphicon glyphicon-book\"></span> About Us</a>" + 
"                </li>" + 
"            </ul>" + 
"        </div>" + 
"    </nav>" + 
"    <div th:replace=\"${template}\"/>" + 
"" + 
"    <script th:src=\"@{/webjars/jquery/jquery.min.js}\"></script>" + 
"    <script th:src=\"@{/webjars/jquery-ui/jquery-ui.min.js}\"></script>" + 
"    <script th:src=\"@{/webjars/bootstrap/js/bootstrap.min.js}\"></script>");



 
        result.println("<h1>Search Results</h1>" + 
                        "<hr>");

        result.println("<ul>");
        //Get the identifier of the item
        String firstName = request.getParameter("FirstName");
        String middleName = request.getParameter("MiddleName");
        String lastName = request.getParameter("LastName");
        String born = request.getParameter("YearBorn");
        String died = request.getParameter("YearDied");
        result.println("<li>");
        if (firstName != null) {
            result.println(firstName + " ");
        }
        if (middleName != null) {
            result.println(middleName + " ");
        }
        if (lastName != null) {
            if (born != null) {
                result.println(lastName + ", ");
            } else{
                result.println(lastName + " ");
            }
        }
        if (born != null) {
            if (died != null) {
                result.println("Born " + born + ", ");
            } else {
                result.println("Born " + born + " ");
            }
        }
        if (died != null) {
            result.println("Died " + died);
        }
        result.println("</li>");
        result.println("</ul>");

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
}