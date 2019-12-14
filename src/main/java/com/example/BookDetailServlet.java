package com.example;

public class BookDetailServlet extends HttpServlet {

    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {
        ...
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
    ...
}