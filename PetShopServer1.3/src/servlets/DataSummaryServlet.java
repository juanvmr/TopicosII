package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import models.*;

@WebServlet("/ClientRegister")
public class DataSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration e = (Enumeration) (request.getSession().getAttributeNames());
        PrintWriter resp = response.getWriter();
        int count = 0;
        
        resp.append("<html>"
        		+ "<head></head>"
        		+ "<body>");

        while ( e.hasMoreElements())
        {
            String string;
        	string = e.nextElement().toString();
            if(string!=null)
            {
            	resp.append(request.getAttribute(string).toString());
            	resp.append("\n");
            	count++;
            }

        }
        resp.append("Quantidade de elementos: "+count);
        resp.append("</body>"
        		+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}