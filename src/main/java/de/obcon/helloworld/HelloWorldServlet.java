package de.obcon.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
    
    private static final long serialVersionUID = -1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = new PrintWriter(response.getOutputStream());
        
        out.println("<style>* { font-family: Helvetica, Arial, sans-serif; } </style>");
        out.println("<h1>HELLO WORLD!</h1>");
        out.println("<h2>" + new Date() + "</h2>");
        out.println("<hr />");
        out.println();

        out.println("<h3>ENV</h3>");
        out.println("<table>");
        for (String key : System.getenv().keySet()) {
            out.println("<tr>");
            out.println("<td width='300px'>" + key + "</td>");
            out.println("<td>" + System.getenv(key) + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println();
        out.println("<hr />");
        out.println();

        out.println("<h3>SYSTEM</h3>");
        out.println("<table>");
        for (Object key : System.getProperties().keySet()) {
            out.println("<tr>");
            out.println("<td width='300px'>" + key + "</td>");
            out.println("<td>" + System.getProperty((String)key) + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.flush();
        out.close();
    }
}
